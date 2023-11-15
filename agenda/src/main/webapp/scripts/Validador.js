function validar() {
  let nome = document.forms["frmContato"]["nome"].value;
  let fone = document.forms["frmContato"]["fone"].value;
  let email = document.forms["frmContato"]["email"].value;

  if (nome === "") {
    alert("PREENCHA O CAMPO NOME");
    document.forms["frmContato"]["nome"].focus();
    return false;
  } else if (fone === "") {
    alert("PREENCHA O CAMPO FONE");
    document.forms["frmContato"]["fone"].focus();
    return false;
  } else if (email === "") {
    alert("PREENCHA O CAMPO E-MAIL");
    document.forms["frmContato"]["email"].focus();
    return false;
  } else {
    document.forms["frmContato"].submit();
  }
}
