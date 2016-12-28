<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>
        <bean:message key="label.leadCreateEdit.title" locale="display" />
    </title>
    <!-- CSS -->
    <link rel="stylesheet" href="css/main.css" type="text/css" />
    <link rel="stylesheet" href="css/theme.css" type="text/css" />

</head>

<body id="public">
<script language="JavaScript" type="text/javascript">
    function actionValue(value) {
        document.registerForm.action.value = value;
    }
</script>
<div id="container">
<html:form action="/register" method="post" styleClass="javachap topLabel" styleId="form3">

        <html:hidden property="action" />
        <html:hidden property="id" />

        <div class="info">
            <logic:empty name="registerForm" property="id">
                <h2>
               		<bean:message key="label.Registration.heading" locale="display" />
                </h2>
            </logic:empty>
	            <p>
	               <bean:message key="label.Registration.headingCaption" locale="display" />
	            </p>
        </div>

        <logic:messagesPresent>
            <li id="errorLi">
            <h3 id="errorMsgLbl">
                <bean:message key="error.label.mainName" locale="display"/>
            </h3>
            <p id="errorMsg">
                <bean:message key="error.label.subName1" locale="display"/>
                <strong> <bean:message key="error.label.subName2" locale="display"/> </strong>
                <bean:message key="error.label.subName3" locale="display"/>
            </p>
            </li>
        </logic:messagesPresent>

        <ul>
            <li class="<logic:messagesPresent property='userName'>error</logic:messagesPresent>">
                <label class="desc" id="lblUserName" for="txtUserName">
                	<bean:message key="label.userName" locale="display"/>
                	<span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:text styleId="txtUserName" property="userName"
                                tabindex="1" maxlength="255"/>
                </div>
                <logic:messagesPresent property="userName">
                    <p class="error"><html:errors property="key.error.userName" locale="display"/></p>
                	<p class="error"><html:errors property="key.error.userNameDuplicate" locale="display"/></p> 
                </logic:messagesPresent>
            </li>

            <li class="<logic:messagesPresent property='passWord'>error</logic:messagesPresent>" id="fo3li0" >
                <label id="lblPassWord" class="desc" for="txtPassWord">
                	<bean:message key="label.passWord" locale="display"/>
                	<span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:text styleId="txtPassWord" property="passWord" tabindex="1" maxlength="255" />
                </div>
                <logic:messagesPresent property="passWord">
                    <p class="error"><html:errors property="key.error.passWord" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="<logic:messagesPresent property='email'>error</logic:messagesPresent>" id="fo3li0" >
                <label class="desc" id="lblEmail" for="txtEmail">
                	<bean:message key="label.email" locale="display"/>
                	<span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:text styleId="txtEmail" property="email" tabindex="3" maxlength="255" />
                </div>
                <logic:messagesPresent property="email">
                    <p class="error"><html:errors property="key.error.email" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="<logic:messagesPresent property='phoneNo'>error</logic:messagesPresent>" id="fo3li0" >
                <label class="desc" id="lblPhoneNo" for="txtPhoneNo">
                	<bean:message key="label.phoneNo" locale="display"/>
                	<span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:text styleId="txtPhoneNo" property="phoneNo" tabindex="4" maxlength="255" />
                </div>
                <logic:messagesPresent property="phoneNo">
                    <p class="error"><html:errors property="key.error.phoneNo" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="<logic:messagesPresent property='firstName'>error</logic:messagesPresent>" id="fo3li0" >
                <label class="desc" id="lblFirstName" for="txtFirstName">
                	<bean:message key="label.firstName" locale="display"/>
                	<span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:text styleId="txtFirstName" property="firstName" tabindex="5" maxlength="255" />
                </div>
                <logic:messagesPresent property="firstName">
                    <p class="error"><html:errors property="key.error.firstName" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="<logic:messagesPresent property='lastName'>error</logic:messagesPresent>" id="fo3li0" >
                <label class="desc" id="lblLastName" for="txtLastName">
                	<bean:message key="label.lastName" locale="display"/>
                	<span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:text styleId="txtLastName" property="lastName" tabindex="5" maxlength="255" />
                </div>
                <logic:messagesPresent property="lastName">
                    <p class="error"><html:errors property="key.error.lastName" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="buttons">
                <html:submit onclick="actionValue('save')">
                    <bean:message key="button.label.save" />
                </html:submit>
                <html:submit onclick="actionValue('cancel')">
                    <bean:message key="button.label.cancel" />
                </html:submit>
            </li>
        </ul>
</html:form>
</div><!--container-->
</body>
</html>
