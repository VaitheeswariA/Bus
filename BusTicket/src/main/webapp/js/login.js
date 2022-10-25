var login = {
	
	submitLogin : function(){
		var emailId = $("#emailId").val();
		var password = $("#password").val();
		var validationStatus = login.validateInput(emailId,password);
		if(validationStatus){
			var successFunc=function(resp){
				if(resp!=null){
					
				}
			}
			var failureFunc=function(resp){
				if(resp!=null){
					
				}
			}
			apiUtil.ajaxPostMethod("login", {"action":"login","emailId":emailId,"password":password}, true, "json", successFunc, failureFunc);	
		//?action=login&emailId="+emailId+"&password="+password
		}
	},
	bindEvents : function(){
		$("#submitBtn").off("click").on("click", function(){
			login.submitLogin();
		});
		$("#signupBtn").off("click").on("click", function(){
			window.location.href="html/signup.html";
			login.signUp();
		});
	},
	signUp : function(){
		var name=$("#passengerName").val();
		var emailId=$("#emailId").val();
		var password=$("#password").val();
		var mobilenumber=$("#mobilenumber").val();
		var validation=login.validateInput(emailId,password);
		if(validation){
			var successFunc=function(resp){
				if(resp!=null){
					window.location.href="login";
				}
			}
			var failureFunc=function(resp){
				if(resp!=null){
					
				}
			}
			apiUtil.ajaxPostMethod("signup", {"action":"signUp","name":name,"emailId":emailId,"password":password,"mobilenumber":mobilenumber}, true, "json", successFunc, failureFunc);	
		//?action=login&emailId="+emailId+"&password="+password
		}
	},
	validateInput : function(emailId,password){
		var validRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if (emailId.match(validRegex) != null)
  			{
    			if(password.length < 8) {  
     			$('body')
				  .toast({
				    title: 'Error!',
				    message: 'Password should have atleast 8 charcters',
				    showProgress: 'bottom',
				    classProgress: 'red'
				  });
				  return false;			
				}  
				return true;
  			}
  			else
  			{
				$('body')
				  .toast({
				    title: 'Error!',
				    message: 'Invalid Email Id',
				    showProgress: 'bottom',
				    classProgress: 'red'
				  });
				  return false;
			}
    		
    		
	}
}