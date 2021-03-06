<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <link href="/resources/css/userPage.css" rel="stylesheet">
    <link href="/resources/css/font-awesome.css" rel="stylesheet">
    <script src="/resources/js/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="/resources/css/jquery-ui.min.css">
    <script src="/resources/js/profile.js"></script>

</head>
<body>
<%@ page isELIgnored="false" %>

<%@ include file="header.html" %>

<div class="container text-center">
    <div class="row">
        <div class="col-lg-4 well">
            <div class="well">

                <div class="col-lg-12 avatar">
                    <img id="avatar" src="/image/avatar/${user.id}"
                         width="265" height="265" class="img-circle" alt="Avatar">
                </div>

                <p></p>
                <p>${user.firstName}</p>
                <p>${user.lastName}</p>
                <p>${user.birthdayDate}</p>
                <p>${user.userType}</p>

                <button type="button" class=" btn btn-default btn-sm" data-toggle="modal"
                        data-target="#newMessage">Write a message
                </button>
                <!-- Modal -->
                <div class="modal fade" id="newMessage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="vertical-alignment-helper">
                        <div class="modal-dialog vertical-align-center">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"><span
                                            aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                                    </button>
                                    <h4 class="modal-title" id="myModalLabel">New message</h4>
                                </div>
                                <div class="modal-body interests-section">
                                    <div class="row">
                                            <div class="form-group">
                                                <textarea id="newMessageText" style="text-align: justify"
                                                          class="form-control" rows="5"></textarea>
                                            </div>
                                            <button id="sendMessage" type="submit" class="btn btn-primary btn-md"
                                                    style="float: right;">
                                                Send
                                            </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="well">
                <h4>${user.userType.equals("customer") ? "Interests" : "Coach specialization"}</h4>
                <ul id="disciplinesList" class="list-group">

                </ul>
            </div>
        </div>

        <div class="col-lg-8">
            <div id="description" class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default text-left">
                        <div style="padding: 1%" class="panel-body">
                            <pre style="border: none; background: none; padding: 0%">${user.description}</pre>
                        </div>
                    </div>
                </div>
            </div>

            <h3>Feedbacks</h3>

            <div id="feedbacks" class="row">

            </div>

            <button id="addFeedback" type="button" style="margin-bottom: 2%; margin-left: 2%; float: left;"
                    class="btn btn-default btn-sm" data-toggle="modal" data-target="#newFeedbackTextWindow">Add feedback
            </button>

            <!-- Modal -->
            <div class="modal fade" id="newFeedbackTextWindow" tabindex="-1" role="dialog"
                 aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="vertical-alignment-helper">
                    <div class="modal-dialog vertical-align-center">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span
                                        aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                                </button>
                                <h4 class="modal-title">Add feedback</h4>
                            </div>
                            <div class="modal-body interests-section">
                                <div class="row">
                                    <div class="form-group">
                                            <textarea id="newFeedbackText" name="newFeedback"
                                                      placeholder="Add your feedback" style="text-align: justify"
                                                      class="form-control" rows="5"></textarea>
                                    </div>
                                    <button id="saveFeedback" type="button" class="btn btn-primary btn-md"
                                            style="float: right;">
                                        Save
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.html" %>

<script>
    //send new feedback text to server


</script>

</body>
</html>