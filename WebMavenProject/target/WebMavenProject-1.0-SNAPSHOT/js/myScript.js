/* 
 * 
 * Full List.js documentations on https://listjs.com/examples, https://listjs.com/api/ 
 * 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    //Check if your Javascript is being loaded on the page [DEBUG]
    //alert("done");
    console.log("loaded");

    var options = {
        valueNames: ['name', 'born']
    };

    var userList = new List('users', options);

    //adding manually using JS
    userList.add({
        name: "Bob Marley",
        born: 1983
    });

    $('#clearALL-btn').click(function () {
        userList.clear();
    });
    
    //V1 - locally 
    $('#add-btn').click(function () {
        userList.add({
            id: Math.floor(Math.random() * 110000),
            name: $('#name-field').val(),
            born: $('#born-field').val()
        });
        clearFields();
    });
    
    // Request from web service 
    // more - https://www.tutorialsteacher.com/jquery/jquery-get-method //
    $('#tdbLoad-btn').click(function () {
        //v1
        var urlStr = "http://localhost:8080/person/getUsersList";
        if($('#name-field').val()!==""){
            urlStr+= "?id="+ $('#name-field').val();
        }else{
            urlStr+= "?id=0";
        }
        console.log(urlStr);
        $.ajax({
            url: urlStr,
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'*',/**/
                'Access-Control-Allow-Credentials' : true,
                'Access-Control-Allow-Methods':'GET',
                'Access-Control-Allow-Headers':'application/json'
            },
            type: "GET", /* or type:"POST", "GET" or type:"PUT" */
            /*dataType: "jsonp",*/
            data: {},
            success: function (result) {
                /*var jsonArray = JSON.parse(result);*/
                var append= '';
                $.each(result, function(i, $val){
                    append+= $val.userID + ',' + $val.individualName + ', ' + $val.heartRate;
                    userList.add({name: $val.individualName, born: $val.personalDetails.bornYear});
                });
                console.log(result);
                console.log(result[1].individualName);
                console.log(append);
            },
            error: function () {
                console.log("error");
            }
        });

    });
});

function clearFields() {
    $('#name-field').val('');
    $('#born-field').val('');
}

