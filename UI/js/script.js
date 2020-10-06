var transaction_type = 'cash';
var balance = 2000;
window.onload = function init() {
  document.getElementById('acc_bal').innerHTML = "Account Balance : $" + balance;
  document.getElementById("enter").addEventListener("click", enterAmount);
}

console.log('loaded');

function handleClick(myRadio) {
  let dropDown = myRadio.value;
  if (dropDown === "Cash Deposit" || dropDown === "Check Deposit") {
    document.getElementById("amount").placeholder = dropDown + " " + "Amount"
    document.getElementById('acc_num').style.display = 'none';
  } else if (dropDown === "Transaction") {
    document.getElementById("amount").placeholder = "Transfer Amount";
    document.getElementById('acc_num').style.display = 'none';
  } else {
    document.getElementById("amount").placeholder = "Withdrawl Amount";
    document.getElementById('acc_num').style.display = 'inline';
  }
}




function transaction(amount, type) {
  if (type === "cash") {
    balance = (+balance + +amount);
    document.getElementById('message').style.display = 'block';
    var mes = "$" + amount + " cash deposit successful";
    document.getElementById('message').innerHTML = mes.fontcolor("green");
    document.getElementById('acc_bal').innerHTML = "Account Balance : $" + balance;
  } else

  if (type === "check") {
    balance = (+balance + +amount);
    document.getElementById('message').style.display = 'block';
    var mes = "$" + amount + " check deposit successful";
    document.getElementById('message').innerHTML = mes.fontcolor("green");
    document.getElementById('acc_bal').innerHTML = "Account Balance : $" + balance;
  } else

  if (type === "withdraw") {
    //Checking if balance is low
    if (balance < amount) {
      document.getElementById('message').style.display = 'block';
      var mes = "Insufficient Account Balance";
      document.getElementById('message').innerHTML = mes.fontcolor("yellow");
    } else {
      balance = (+balance - +amount);
      document.getElementById('message').style.display = 'block';
      var mes = "$" + amount + " withdraw successful";
      document.getElementById('message').innerHTML = mes.fontcolor("green");
      document.getElementById('acc_bal').innerHTML = "Account Balance : $" + balance;;
    }
  } else {
    if (balance < amount) {
      document.getElementById('message').style.display = 'block';
      var mes = "Insufficient Account Balance";
      document.getElementById('message').innerHTML = mes.fontcolor("yellow");
    } else {
      var accNum = document.getElementById("acc_num").value;
      balance = (+balance - +amount);
      document.getElementById('message').style.display = 'block';
      var mes = "$" + amount + " transfered to account number " + accNum + " successfully";
      document.getElementById('message').innerHTML = mes.fontcolor("green");
      document.getElementById('acc_bal').innerHTML = "Account Balance : $" + balance;
    }
  }

}

function enterAmount() {

  //This function is called on click of submit button. Basic validations are done in this function. If every input is validated then it will call transaction function
  var amount = document.getElementById("amount").value;
  if (amount === "") {
    document.getElementById('message').style.display = 'block';
    var mes = "Please Enter an Amount";
    document.getElementById('message').innerHTML = mes.fontcolor("red");
  } else {
    type = transaction_type;
    if (type === "transfer") {
      if (document.getElementById("acc_num").value === "") {
        document.getElementById('message').style.display = 'block';
        var mes = "Please Enter Reciever Account Number";
        document.getElementById('message').innerHTML = mes.fontcolor("red");
      } else {
        transaction(amount, type);
      }
    } else {
      transaction(amount, type);
    }
  }

}
