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
<script type="text/javascript">

function getParameterByName(name, url) {
    if (!url) {
      url = window.location.href;
    }
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}
  	function actionValue(value, id) {
  	   var id = getParameterByName('roomTypeId');
  	 
  	   document.roomTypeForm.roomTypeId.value = parseInt(id);
       document.roomTypeForm.action.value = value;
    }
	function loadVariable(){
	  	var des = getParameterByName('description');
	  	var maxCap = getParameterByName('maxCapacity');
	  	document.getElementById("txtDescription").value = des;
	  	document.getElementById("txtMaxCapacity").value = maxCap;
	}
	 window.onload = loadVariable;
</script>
<%@ page import="java.util.List" %>
<div id="container">
<html:form action="/roomType" method="post" styleClass="javachap topLabel" styleId="form3">

        <html:hidden property="action" />
        <html:hidden property="roomTypeId" />
    
        <div class="info">
            <logic:empty name="roomTypeForm" property="roomTypeId">
                <h2>
               		<bean:message key="label.CreateRoomType.heading" locale="display" />
                </h2>
            </logic:empty>
             <logic:notEmpty name="roomTypeForm" property="roomTypeId">
                <h2>
                    <bean:message key="label.UpdateRoomType.heading" locale="display" />
                </h2>
            </logic:notEmpty>
	            <p>
	               <bean:message key="label.RoomType.headingCaption" locale="display" />
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
            <li class="<logic:messagesPresent property='description'>error</logic:messagesPresent>">
                <label class="desc" id="lblDescription" for="txtDescription">
                	<bean:message key="label.description" locale="display"/>
                	<span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:text styleId="txtDescription" property="description"
                                tabindex="1" maxlength="255"/>
                </div>
                <logic:messagesPresent property="description">
                    <p class="error"><html:errors property="key.error.RoomTypeDescription" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="<logic:messagesPresent property='maxCapacity'>error</logic:messagesPresent>" id="fo3li0" >
                <label id="lblPassWord" class="desc" for="txtMaxCapacity">
                	<bean:message key="label.maxCapacity" locale="display"/>
                	<span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:text styleId="txtMaxCapacity" property="maxCapacity" tabindex="1" maxlength="255" />
                </div>
                <logic:messagesPresent property="maxCapacity">
                    <p class="error"><html:errors property="key.error.RoomTypeMaxCapacity" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="buttons">
                  <html:submit
                            onclick="actionValue('Save')">
                    <bean:message key="button.label.save" locale="display"/>
                </html:submit>
                <html:submit 
                            onclick="actionValue('Cancel')">
                    <bean:message key="button.label.cancel" locale="display"/>
                </html:submit>
            </li>
        </ul>
</html:form>
</div><!--container-->
</body>
</html>
