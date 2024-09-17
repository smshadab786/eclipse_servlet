var btnAdd=document.getElementById('btnAdd');
var userForm=document.getElementById('userForm');

btnAdd.addEventListener("click",function(){
	userForm.style.display="block";
})

userForm.addEventListener("reset",function(){
	userForm.style.display="none";
})