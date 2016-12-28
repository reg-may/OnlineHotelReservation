<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <title><bean:message key="label.leadListing.title" locale="display"/></title>
    <!-- CSS -->
    <link rel="stylesheet" href="css/main.css" type="text/css" />
    <link rel="stylesheet" href="css/theme.css" type="text/css" />

</head>

<body id="public">

<script language="JavaScript" type="text/javascript">


function selectAll(deleteMain) {
    var trCount = document.getElementsByTagName('tr').length;
    
    if (deleteMain.checked) {
        for (var i = 0; i < trCount-1; i++) {
            document.getElementById(i.toString()).checked = true;
        }
    }
    else {
        for (var i = 0; i < trCount-1; i++) {
            document.getElementById(i.toString()).checked = false;
        }
    }
}

function validate() {
    var count = 0;
    var trCount = document.getElementsByTagName('tr').length;
    for (var i = 0; i < trCount-1; i++) {
        if (document.getElementById(i.toString()).checked) {
            count++;
        }
    }
    if (count > 0) {
        return true;
    }
    else {
        alert("Sorry, select Room Type and press Delete");
        return false;
    }

}

</script>

<div id="container">

    <div class="javachap" style="margin:20px 20px 0; padding:0 0 20px;">

        <div class="info">
            <div class="buttons">

                <html:link tabindex="5" title="Add a Room Type" action="addRoomType" styleClass="positive">
                    <html:img src="images/new_lead.png" styleClass="icon" />
                    <bean:message key="link.label.newRoomType" locale="display" />!
                </html:link>
            </div>
            <h2>
                <bean:message key="label.roomTypeList.heading" locale="display" />
            </h2>
            <p>
                <bean:message key="label.roomTypeList.headingCaption" locale="display" />!
            </p>
        </div>

        <logic:messagesPresent message="true">
            <div style="color:green!important;margin:5px;">
                <html:messages message="true" id="message" locale="display">
                    <bean:write name="message"/>
                </html:messages>
            </div>
        </logic:messagesPresent>

        <logic:messagesPresent >
            <div style="color:red!important;margin:5px;">
                <html:errors locale="display"/>
            </div>
        </logic:messagesPresent>

        <html:form action="/roomTypeAll" method="post">

            <html:hidden property="action" value="deleteRoomTypes"/>

            <table width="100%" id="stuff">
                <tr>
                    <th><input type="checkbox" id="deleteMain" onclick="selectAll(this);" tabindex="6" /></th>
                    <th width="30%"><bean:message key="label.description" locale="display"/></th>
                    <th width="20%"><bean:message key="label.maxCapacity" locale="display"/></th>
                    <th width="25%"><bean:message key="label.action" locale="display"/></th>
                </tr>
                <tbody>
                    <logic:empty name="roomTypeList">
                        <tr>
                            <td colspan="6" style="text-align:center;">
                                <bean:message key="label.noRoomTypes" locale="display"/>
                            </td>
                        </tr>
                    </logic:empty>
                    <logic:notEmpty name="roomTypeList">
                        <logic:iterate id="roomType" indexId="i" name="roomTypeList" type="com.hotel.domain.service.RoomTypeService">
                            <tr>
                                <td>
                                	<bean:define id="roomTypeId" name="roomType" property="id" />
                                    <html:checkbox property="roomTypeIds" value="<%=roomType.getId().toString()%>" styleId="<%=i.toString()%>" />
                               		<bean:write name="roomType" property="id" /> 
                                </td>
                                <td><bean:write name="roomType" property="description" /></td>
                                <td><bean:write name="roomType" property="maxCapacity" /></td>
                                <td>
                                
                           
                               	 <bean:define id="descrip" name="roomType" property="description" />
                               	 <bean:define id="maxCap" name="roomType" property="maxCapacity" />
                               	 <% String des = descrip.toString();
                               	 	String cap = maxCap.toString();	
                               	 %>
                                <html:link tabindex="8" action="/addRoomType" paramId="roomTypeId" paramName="roomType" paramProperty="id">
                                		<html:param name="action" value="Update" />
                                		<html:param name="description" value='<%= des %>' />
                                		<html:param name="maxCapacity" value='<%= cap %>' />
                                        <bean:message key="link.label.update" locale="display" />
                               </html:link> 
                                <html:link tabindex="9" action="/roomTypeAll" paramId="roomTypeId" paramName="roomType" paramProperty="id" >
                                        <html:param name="action" value="Delete" />
                                        <bean:message key="link.label.delete" locale="display" />
                               </html:link>
                              
                                </td>
                            </tr>
                        </logic:iterate>
                    </logic:notEmpty>
                </tbody>
            </table>

            <div class="buttons">
                <html:submit styleId="deleteForm" styleClass="btTxt imgStyle" tabindex="8"
                            title="Delete selected Room Types" >
                  <bean:message key="button.label.delete" locale="display" />
                </html:submit>
            </div>

        </html:form>

    </div>

</div><!--container-->
</body>
</html>
