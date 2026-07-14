AjaxScript.js;

function getEmployeeDetails() {
  var eid = document.getElementById("eid").value.trim();
  if (!eid) {
    document.getElementById("ename").value = "";
    document.getElementById("esalary").value = "";
    document.getElementById("dno").value = "";
    return;
  }

  var req = new XMLHttpRequest();
  req.open("GET", "EmployeeController?eid=" + encodeURIComponent(eid), true);

  req.onreadystatechange = function () {
    if (req.readyState == 4 && req.status == 200) {
      var result = req.responseText.trim();
      if (
        result === "NOT_FOUND" ||
        result === "INVALID_ID" ||
        result === "DB_ERROR"
      ) {
        document.getElementById("ename").value = "";
        document.getElementById("esalary").value = "";
        document.getElementById("dno").value = "";
        return;
      }

      var arr = result.split(" ");
      document.getElementById("ename").value = arr[0] || "";
      document.getElementById("esalary").value = arr[1] || "";
      document.getElementById("dno").value = arr[2] || "";
    }
  };
  req.send();
}
