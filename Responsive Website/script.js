function appending(values){
var x = document.getElementById(values).value;
console.log(x);
document.getElementById("hel").value += x;

}

function evaluating() {
try {
var exp = document.getElementById("hel").value;
console.log(eval(exp));
document.getElementById("hel").value = eval(exp);

}
catch(err) {
alert("Wrong Input: "+err.message);
clearing();
}
}
function clearing(){
document.getElementById("hel").value = "";
}