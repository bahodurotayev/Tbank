function clicked() {
  document.getElementById('lblError').innerHTML = '';
  var uname = document.getElementById('email').value.trim();
  var pwd = document.getElementById('pwd1').value;

  if (uname == '' && pwd == '') {
    document.getElementById('lblError').innerHTML = ' * Username and Password are required';
    return false;
  }

  if (uname == '') {
    document.getElementById('lblError').innerHTML = ' * Please enter Username ';
    return false;
  }

  if (pwd == '') {
    document.getElementById('lblError').innerHTML = ' * Please enter Password';
    return false;
  }

  if (uname != 'technobank') {
    document.getElementById('lblError').innerHTML = ' * Invalid Credentials';
    return false;
  }

  if (!isNaN(uname)) {
    document.getElementById('lblError').innerHTML = ' * Only characters are allowed in Username';
    return false;
  }

  if (pwd != 12345678) {
    document.getElementById('lblError').innerHTML = ' * Invalid Credentials';
    return false;
  } else {
    window.location = 'ACCOUNT SUMMARY PAGE.html';
  }
}

// function validateUserName(email) {
//            var regex = /^[0-9a-zA-Z_]+$/;
//            if (name.length < 8)
//                document.getElementById("msg1").innerHTML = "Username is too short";
//            else if (name.length > 15)
//                document.getElementById("msg1").innerHTML = "Username is too long";
//            else if (!name.match(regex)) {
//                document.getElementById("msg1").innerHTML = "Invalid characters in Username";
//            } else document.getElementById("msg1").innerHTML = "";
//                return;
//        } // end function validateUserName

//        function validatePassword(pwd1) {
//            var regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
//            if (password.length < 8)
//                document.getElementById("msg2").innerHTML = "Password is too short (min. 8 characters)";
//            else if (password.length > 15)
//                document.getElementById("msg2").innerHTML = "Password is too long (max. 15 characters)";
//            else if (!password.match(regex)) {
//                document.getElementById("msg2").innerHTML = "Invalid Password";
//            } else document.getElementById("msg2").innerHTML = "";
//                return;
