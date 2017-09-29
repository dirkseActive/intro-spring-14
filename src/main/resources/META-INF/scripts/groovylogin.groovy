 class GroovyLoginService implements Login{ 
 	String username
 	String password
 	
 	boolean isAuthorized(String email, string pass){ 
 	if(username==email && password==pass)
 		return true
 	return false
 	}
 }