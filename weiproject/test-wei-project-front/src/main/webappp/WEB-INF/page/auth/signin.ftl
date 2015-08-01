<#assign javascripts=['javascript/login/ie-emulation-modes-warning.js','javascript/login/ie10-viewport-bug-workaround.js'] >
<#assign css=['css/signin.css']>
<#include "../common/commonPage.ftl">
<@html title="Signin" javascripts=javascripts css=css>
    <div class="container">
      <form class="form-signin" action"" method="POST">
      	<label>${error!''}</label>
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" id="inputEmail" name="loginName"  class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
    </div>
</@html>
