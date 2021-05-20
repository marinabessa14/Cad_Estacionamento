/**
 * 
 */
 
 
 function entrar() {
 	var login = {
 		usuario: document.getElementById("txtUsuario").value,
 		senha: document.getElementById("txtSenha").value
 	}
 	
 	var json = JSON.stringify(login);
 	
    //gravando o token JWT no usuário
    sessionStorage.setItem('meutoken', json);
    //redirecionando para outra página
    window.location.href = "veiculo.html";
 
 }