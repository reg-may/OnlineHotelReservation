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
        document.roomForm.action.value = value;
    }

</script>

<%@ page import="com.hotel.domain.RoomType" %>
<%@ page import="java.util.List" %>

<div id="container">
    <html:form action="/addOnlineHotelRoom" method="post" styleClass="javachap topLabel" styleId="form3">

        <html:hidden property="action"  />
        <html:hidden property="roomId" />

        <div class="info">
            <logic:empty name="roomForm" property="roomId">
                <h2>
                    <bean:message key="label.roomCreate.heading" locale="display" />
                </h2>
            </logic:empty>
            <logic:notEmpty name="roomForm" property="roomId">
                <h2>
                    <bean:message key="label.roomUpdate.heading" locale="display" />
                </h2>
            </logic:notEmpty>
            <p>
               <bean:message key="label.Room.headingCaption" locale="display" />
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

            <li class="<logic:messagesPresent property='roomType'>error</logic:messagesPresent>" id="fo3li7" >
                <label class="desc" id="lblRoomType" for="sltRoomType">
                <bean:message key="label.room.RoomType" locale="display"/> <span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:select styleClass="field select medium" styleId="sltRoomType" property="roomType" tabindex="1" >
                        <html:option value="Select any Room Type">
                            <bean:message key="label.option.RoomType.default" locale="display" />
                        </html:option>
                        <html:optionsCollection name="roomTypeList2" label="description" value="id" />
                    </html:select>
                </div>
                <logic:messagesPresent property="roomType">
                    <p class="error"><html:errors property="roomType" locale="display"/></p>
                </logic:messagesPresent>
            </li>
            
             <li class="<logic:messagesPresent property='number'>error</logic:messagesPresent>" id="fo3li0" >
                <label id="lblNumber" class="desc" for="txtNumber">
                <bean:message key="label.room.Number" locale="display"/> <span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:text styleId="txtNumber" styleClass="field textarea medium" property="number" tabindex="2" />
                </div>
                <logic:messagesPresent property="number">
                    <p class="error"><html:errors property="number" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="<logic:messagesPresent property='name'>error</logic:messagesPresent>" id="fo3li0" >
                <label class="desc" id="lblName" for="txtName">
                <bean:message key="label.room.Name" locale="display"/> <span id="req_111" class="req">*</span>
                </label>
                <div>
                    <html:text styleId="txtName" styleClass="field text medium" property="name"
                                tabindex="1" maxlength="255"/>
                </div>
                <logic:messagesPresent property="name">
                    <p class="error"><html:errors property="name" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="<logic:messagesPresent property='status'>error</logic:messagesPresent>" id="fo3li0" >
                <label class="desc" id="lblStatus" for="sltStatus">
                <bean:message key="label.room.Status" locale="display"/> <span id="req_111" class="req">*</span>
                </label>
                <div>
                      <html:select styleClass="field select Status" styleId="sltStatus" property="status" tabindex="1" >
                      		<html:option value="option.room.Default"><bean:message key="option.room.Default" locale="display" /></html:option>
                    		<html:option value="option.room.Occupied"><bean:message key="option.room.Occupied" locale="display" /></html:option>
                    		<html:option value="option.room.StayOver"><bean:message key="option.room.StayOver" locale="display" /></html:option>
                    		<html:option value="option.room.OnChange"><bean:message key="option.room.OnChange" locale="display" /></html:option>
                    		<html:option value="option.room.DoNotDisturb"><bean:message key="option.room.DoNotDisturb" locale="display" /></html:option>
                   	  		<html:option value="option.room.CleaningInProgress"><bean:message key="option.room.CleaningInProgress" locale="display" /></html:option>
                   	  		<html:option value="option.room.Sleep-out"><bean:message key="option.room.Sleep-out" locale="display" /></html:option>
                   	  		<html:option value="option.room.On-Queue"><bean:message key="option.room.On-Queue" locale="display" /></html:option>
                   	  		<html:option value="option.room.Skipper"><bean:message key="option.room.Skipper" locale="display" /></html:option>
                   	  		<html:option value="option.room.VacantAndReady"><bean:message key="option.room.VacantAndReady" locale="display" /></html:option>
                   	  		<html:option value="option.room.OutOfOrder"><bean:message key="option.room.OutOfOrder" locale="display" /></html:option>
                   	  		<html:option value="option.room.OutOfService"><bean:message key="option.room.OutOfService" locale="display" /></html:option>
                   	  		<html:option value="option.room.LockOut"><bean:message key="option.room.LockOut" locale="display" /></html:option>
                   	  		<html:option value="option.room.DNCO"><bean:message key="option.room.DNCO" locale="display" /></html:option>
                   	  		<html:option value="option.room.DueOut"><bean:message key="option.room.DueOut" locale="display" /></html:option>
                   	  		<html:option value="option.room.Check-Out"><bean:message key="option.room.Check-Out" locale="display" /></html:option>
                   	  		<html:option value="option.room.LateCheck-Out"><bean:message key="option.room.LateCheck-Out" locale="display" /></html:option>
                   	   </html:select>
                </div>
                <logic:messagesPresent property="status">
                    <p class="error"><html:errors property="status" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="<logic:messagesPresent property='smoke'>error</logic:messagesPresent>" id="fo3li0" >
                <label class="desc" id="lblSmoke" for="sltSmoke">
                <bean:message key="label.room.Smoke" locale="display"/> <span id="req_111" class="req">*</span>
                </label>
                 	  <html:select styleClass="field select Smoke" styleId="sltSmoke" property="smoke" tabindex="1" >
                 	  			<html:option value="option.room.yes"><bean:message key="option.room.yes" locale="display" /></html:option>
                 	  			<html:option value="option.room.no"><bean:message key="option.room.no" locale="display" /></html:option>
                 	  </html:select>
                <div>
                   
                </div>
                <logic:messagesPresent property="smoke">
                    <p class="error"><html:errors property="smoke" locale="display"/></p>
                </logic:messagesPresent>
            </li>

            <li class="buttons">
                <html:submit styleId="saveForm" styleClass="btTxt imgStyle" tabindex="8" title="Submit this Details"
                            onclick="actionValue('Save')">
                    <bean:message key="button.label.save" locale="display"/>
                </html:submit>
                <html:submit styleId="saveForm" styleClass="btTxt imgStyle" tabindex="9" title="Submit this Details"
                            onclick="actionValue('Cancel')">
                    <bean:message key="button.label.cancel" locale="display"/>
                </html:submit>
            </li>

        </ul>

    </html:form>
</div><!--container-->
</body>
</html>
