<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>
<body>
<div class="info">
            <div class="buttons">

                <html:link tabindex="5" title="Sell a New Lead" forward="registration" styleClass="positive">
                    <html:img src="images/new_lead.png" styleClass="icon" />
                    <bean:message key="link.label.newLead" locale="display" />!
                </html:link>
            </div>
            <h2>
                <bean:message key="label.leadListing.heading" locale="display" />
            </h2>
            <p>
                <bean:message key="label.leadListing.headingCaption" locale="display" />!
            </p>
        </div>
</body>
</html>