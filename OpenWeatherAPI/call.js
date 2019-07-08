function getHTTPObject() {
    var xhr = false;
    if(window.XMLHttpRequest){
        xhr = new XMLHttpRequest();        
    }
    else if(window.ActiveXOBject){
        try{
            xhr=new ActiveXObject("Msxml2.XMLHTTP");
        }catch(e){
            xhr=false;
        }
    }
    return xhr;
}
function humid(request){
    
     if(request.readyState==4){
        if(request.status==200||request.status==304){
            var data = request.responseXML;
            var name = data.getElementsByTagName('name')[0].firstChild.nodeValue;
            var con = data.getElementsByTagName('country')[0].firstChild.nodeValue;
            //fetching dates
            var date1 = data.getElementsByTagName('time')[0].attributes.getNamedItem('day').nodeValue;
            var date2 = data.getElementsByTagName('time')[1].attributes.getNamedItem('day').nodeValue;
            var date3 = data.getElementsByTagName('time')[2].attributes.getNamedItem('day').nodeValue;
            var date4 = data.getElementsByTagName('time')[3].attributes.getNamedItem('day').nodeValue;
            var date5 = data.getElementsByTagName('time')[4].attributes.getNamedItem('day').nodeValue;
            var date6 = data.getElementsByTagName('time')[5].attributes.getNamedItem('day').nodeValue;
            var date7 = data.getElementsByTagName('time')[6].attributes.getNamedItem('day').nodeValue;
            ///fetchng for humidity
            var h1 =data.getElementsByTagName('humidity')[0].attributes.getNamedItem('value').nodeValue;
            var h2 =data.getElementsByTagName('humidity')[1].attributes.getNamedItem('value').nodeValue;
            var h3 =data.getElementsByTagName('humidity')[2].attributes.getNamedItem('value').nodeValue;
            var h4 =data.getElementsByTagName('humidity')[3].attributes.getNamedItem('value').nodeValue;
            var h5 =data.getElementsByTagName('humidity')[4].attributes.getNamedItem('value').nodeValue;
            var h6 =data.getElementsByTagName('humidity')[5].attributes.getNamedItem('value').nodeValue;
            var h7 =data.getElementsByTagName('humidity')[6].attributes.getNamedItem('value').nodeValue;


                var ctx = document.getElementById("myChart2").getContext('2d');
                var myChart = new Chart(ctx, {
              type: 'bar',
              data: {
                labels: [date1, date2, date3, date4,date5, date6, date7],
                datasets: [{
                  label: 'Humidty (%)',
                  data: [h1, h2, h3, h4, h5, h6, h7],
                  backgroundColor: "rgba(255,153,0,0.4)"
                }]
              }
            });
            console.log(request.responseText);
        }}
     else if(request.status==404){
        alert("City not found!!Please provide correct name.");   
    }
}

function tab(request){
    
     if(request.readyState==4){
        if(request.status==200||request.status==304){
            var data = request.responseXML;
            var name = data.getElementsByTagName('name')[0].firstChild.nodeValue;
            var con = data.getElementsByTagName('country')[0].firstChild.nodeValue;
            //fetching dates
            var date1 = data.getElementsByTagName('time')[0].attributes.getNamedItem('day').nodeValue;
            var date2 = data.getElementsByTagName('time')[1].attributes.getNamedItem('day').nodeValue;
            var date3 = data.getElementsByTagName('time')[2].attributes.getNamedItem('day').nodeValue;
            var date4 = data.getElementsByTagName('time')[3].attributes.getNamedItem('day').nodeValue;
            var date5 = data.getElementsByTagName('time')[4].attributes.getNamedItem('day').nodeValue;
            var date6 = data.getElementsByTagName('time')[5].attributes.getNamedItem('day').nodeValue;
            var date7 = data.getElementsByTagName('time')[6].attributes.getNamedItem('day').nodeValue;
            ///fetchng for humidity
            var h1 =data.getElementsByTagName('humidity')[0].attributes.getNamedItem('value').nodeValue;
            var h2 =data.getElementsByTagName('humidity')[1].attributes.getNamedItem('value').nodeValue;
            var h3 =data.getElementsByTagName('humidity')[2].attributes.getNamedItem('value').nodeValue;
            var h4 =data.getElementsByTagName('humidity')[3].attributes.getNamedItem('value').nodeValue;
            var h5 =data.getElementsByTagName('humidity')[4].attributes.getNamedItem('value').nodeValue;
            var h6 =data.getElementsByTagName('humidity')[5].attributes.getNamedItem('value').nodeValue;
            var h7 =data.getElementsByTagName('humidity')[6].attributes.getNamedItem('value').nodeValue;
            //fetching max temp
            var max1 = data.getElementsByTagName('temperature')[0].attributes.getNamedItem('max').nodeValue;
            var max2 = data.getElementsByTagName('temperature')[1].attributes.getNamedItem('max').nodeValue;
            var max3 = data.getElementsByTagName('temperature')[2].attributes.getNamedItem('max').nodeValue;
            var max4 = data.getElementsByTagName('temperature')[3].attributes.getNamedItem('max').nodeValue;
            var max5 = data.getElementsByTagName('temperature')[4].attributes.getNamedItem('max').nodeValue;
            var max6 = data.getElementsByTagName('temperature')[5].attributes.getNamedItem('max').nodeValue;
            var max7 = data.getElementsByTagName('temperature')[6].attributes.getNamedItem('max').nodeValue;
            
            //fetching location values
            var alt = data.getElementsByTagName('location')[1].attributes.getNamedItem('altitude').nodeValue;
            var lat = data.getElementsByTagName('location')[1].attributes.getNamedItem('latitude').nodeValue;
            var lon = data.getElementsByTagName('location')[1].attributes.getNamedItem('longitude').nodeValue;
            
            //fetching wind values
            var w1 = data.getElementsByTagName('windSpeed')[0].attributes.getNamedItem('name').nodeValue;
            var wd1 = data.getElementsByTagName('windDirection')[0].attributes.getNamedItem('name').nodeValue;
            var w2 = data.getElementsByTagName('windSpeed')[1].attributes.getNamedItem('name').nodeValue;
            var wd2 = data.getElementsByTagName('windDirection')[1].attributes.getNamedItem('name').nodeValue;
            var w3 = data.getElementsByTagName('windSpeed')[2].attributes.getNamedItem('name').nodeValue;
            var wd3 = data.getElementsByTagName('windDirection')[2].attributes.getNamedItem('name').nodeValue;
            var w4 = data.getElementsByTagName('windSpeed')[3].attributes.getNamedItem('name').nodeValue;
            var wd4 = data.getElementsByTagName('windDirection')[3].attributes.getNamedItem('name').nodeValue;
            var w5 = data.getElementsByTagName('windSpeed')[4].attributes.getNamedItem('name').nodeValue;
            var wd5 = data.getElementsByTagName('windDirection')[4].attributes.getNamedItem('name').nodeValue;
            var w6 = data.getElementsByTagName('windSpeed')[5].attributes.getNamedItem('name').nodeValue;
            var wd6 = data.getElementsByTagName('windDirection')[5].attributes.getNamedItem('name').nodeValue;
            var w7 = data.getElementsByTagName('windSpeed')[6].attributes.getNamedItem('name').nodeValue;
            var wd7 = data.getElementsByTagName('windDirection')[6].attributes.getNamedItem('name').nodeValue;
            
            //fetching values for clouds
            var c1 = data.getElementsByTagName('clouds')[0].attributes.getNamedItem('value').nodeValue;
            var c2 = data.getElementsByTagName('clouds')[1].attributes.getNamedItem('value').nodeValue;
            var c3 = data.getElementsByTagName('clouds')[2].attributes.getNamedItem('value').nodeValue;
            var c4 = data.getElementsByTagName('clouds')[3].attributes.getNamedItem('value').nodeValue;
            var c5 = data.getElementsByTagName('clouds')[4].attributes.getNamedItem('value').nodeValue;
            var c6 = data.getElementsByTagName('clouds')[5].attributes.getNamedItem('value').nodeValue;
            var c7 = data.getElementsByTagName('clouds')[6].attributes.getNamedItem('value').nodeValue;
            
            //fetching for rain
            var r1 = data.getElementsByTagName('symbol')[0].attributes.getNamedItem('name').nodeValue;
            var r2 = data.getElementsByTagName('symbol')[1].attributes.getNamedItem('name').nodeValue;
            var r3 = data.getElementsByTagName('symbol')[2].attributes.getNamedItem('name').nodeValue;
            var r4 = data.getElementsByTagName('symbol')[3].attributes.getNamedItem('name').nodeValue;
            var r5 = data.getElementsByTagName('symbol')[4].attributes.getNamedItem('name').nodeValue;
            var r6 = data.getElementsByTagName('symbol')[5].attributes.getNamedItem('name').nodeValue;
            var r7 = data.getElementsByTagName('symbol')[6].attributes.getNamedItem('name').nodeValue;
             //fetching for image
            var i1 = data.getElementsByTagName('symbol')[0].attributes.getNamedItem('var').nodeValue;
            var i2 = data.getElementsByTagName('symbol')[1].attributes.getNamedItem('var').nodeValue;
            var i3 = data.getElementsByTagName('symbol')[2].attributes.getNamedItem('var').nodeValue;
            var i4 = data.getElementsByTagName('symbol')[3].attributes.getNamedItem('var').nodeValue;
            var i5 = data.getElementsByTagName('symbol')[4].attributes.getNamedItem('var').nodeValue;
            var i6 = data.getElementsByTagName('symbol')[5].attributes.getNamedItem('var').nodeValue;
            var i7 = data.getElementsByTagName('symbol')[6].attributes.getNamedItem('var').nodeValue;
            
            if(c1=="clear sky"){
                var t1 = r1;
            }
            else{
                var t1 = r1 + " with " + c1;
            }
            if(c2=="clear sky"){
                var t2 = r2;
            }
            else{
                var t2 = r2 + " with " + c2;
            }
            if(c3=="clear sky"){
                var t3 = r3;
            }
            else{
                var t3 = r3 + " with " + c3;
            }
            if(c4=="clear sky"){
                var t4 = r4;
            }
            else{
                var t4 = r4 + " with " + c4;
            }
            if(c5=="clear sky"){
                var t5 = r5;
            }
            else{
                var t5 = r5 + " with " + c5;
            }
            if(c6=="clear sky"){
                var t6 = r6;
            }
            else{
                var t6 = r6 + " with " + c6;
            }
            if(c7=="clear sky"){
                var t7 = r7;
            }
            else{
                var t7 = r7 + " with " + c7;
            }
            
            
            var disp = name + "," + con +"<br/><br/>Altitude:" + alt +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;Latitude:"+lat+"<br/>Longitude:"+lon+"<br/>"
            +"<table class='mid' align='center'><th>Date<br/>(YYYY/MM/DD)&nbsp; &nbsp;</th><th>Temperature<br/>(°C)</th><th>Forecast</th><th>Wind</th><th> &nbsp; &nbsp;</th>"
            +"<tr><td>"+ date1 +"</td><td>"+ max1 +"°C</td><td>" + t1 + "</td><td>"+ w1 +","+ wd1 +"</td><td><img src='http://openweathermap.org/img/w/"+i1+".png'></td></tr>"
            +"<tr><td>"+ date2 +"</td><td>"+ max2 +"°C</td><td>" + t2 + "</td><td>"+ w2 +","+ wd2 +"</td><td><img src='http://openweathermap.org/img/w/"+i2+".png'></td></tr>"
            +"<tr><td>"+ date3 +"</td><td>"+ max3 +"°C</td><td>" + t3 + "</td><td>"+ w3 +","+ wd3 +"</td><td><img src='http://openweathermap.org/img/w/"+i3+".png'></td></tr>"
            +"<tr><td>"+ date4 +"</td><td>"+ max4 +"°C</td><td>" + t4 + "</td><td>"+ w4 +","+ wd4 +"</td><td><img src='http://openweathermap.org/img/w/"+i4+".png'></td></tr>"
            +"<tr><td>"+ date5 +"</td><td>"+ max5 +"°C</td><td>" + t5 + "</td><td>"+ w5 +","+ wd5 +"</td><td><img src='http://openweathermap.org/img/w/"+i5+".png'></td></tr>"
            +"<tr><td>"+ date6 +"</td><td>"+ max6 +"°C</td><td>" + t6 + "</td><td>"+ w6 +","+ wd6 +"</td><td><img src='http://openweathermap.org/img/w/"+i6+".png'></td></tr>"
            +"<tr><td>"+ date7 +"</td><td>"+ max7 +"°C</td><td>" + t7 + "</td><td>"+ w7 +","+ wd7 +"</td><td><img src='http://openweathermap.org/img/w/"+i7+".png'?</td></tr>"
            +"</table>";
            console.log(request.responseText);
            document.getElementById('aja').innerHTML = disp;
        }}
     else if(request.status==404){
        alert("City not found!!Please provide correct name.");   
    }
}

function weat(request) {
    if(request.readyState==4){
        if(request.status==200||request.status==304){
            var data = request.responseXML;
            var name = data.getElementsByTagName('name')[0].firstChild.nodeValue;
            var con = data.getElementsByTagName('country')[0].firstChild.nodeValue;
            //fetching dates
            var date1 = data.getElementsByTagName('time')[0].attributes.getNamedItem('day').nodeValue;
            var date2 = data.getElementsByTagName('time')[1].attributes.getNamedItem('day').nodeValue;
            var date3 = data.getElementsByTagName('time')[2].attributes.getNamedItem('day').nodeValue;
            var date4 = data.getElementsByTagName('time')[3].attributes.getNamedItem('day').nodeValue;
            var date5 = data.getElementsByTagName('time')[4].attributes.getNamedItem('day').nodeValue;
            var date6 = data.getElementsByTagName('time')[5].attributes.getNamedItem('day').nodeValue;
            var date7 = data.getElementsByTagName('time')[6].attributes.getNamedItem('day').nodeValue;
            //fetching min temp             
            var min1 = data.getElementsByTagName('temperature')[0].attributes.getNamedItem('min').nodeValue;
            var min2 = data.getElementsByTagName('temperature')[1].attributes.getNamedItem('min').nodeValue;
            var min3 = data.getElementsByTagName('temperature')[2].attributes.getNamedItem('min').nodeValue;
            var min4 = data.getElementsByTagName('temperature')[3].attributes.getNamedItem('min').nodeValue;
            var min5 = data.getElementsByTagName('temperature')[4].attributes.getNamedItem('min').nodeValue;
            var min6 = data.getElementsByTagName('temperature')[5].attributes.getNamedItem('min').nodeValue;
            var min7 = data.getElementsByTagName('temperature')[6].attributes.getNamedItem('min').nodeValue;
            //fetching max temp
            var max1 = data.getElementsByTagName('temperature')[0].attributes.getNamedItem('max').nodeValue;
            var max2 = data.getElementsByTagName('temperature')[1].attributes.getNamedItem('max').nodeValue;
            var max3 = data.getElementsByTagName('temperature')[2].attributes.getNamedItem('max').nodeValue;
            var max4 = data.getElementsByTagName('temperature')[3].attributes.getNamedItem('max').nodeValue;
            var max5 = data.getElementsByTagName('temperature')[4].attributes.getNamedItem('max').nodeValue;
            var max6 = data.getElementsByTagName('temperature')[5].attributes.getNamedItem('max').nodeValue;
            var max7 = data.getElementsByTagName('temperature')[6].attributes.getNamedItem('max').nodeValue;
            
            
            console.log(date1   );  
            
            
            var ctx = document.getElementById('myChart').getContext('2d');
            var myChart = new Chart(ctx, {
              type: 'line',
              data: {
                labels: [date1, date2, date3, date4,date5, date6, date7],
                datasets: [{
                  label: 'Max Temp(°C)',
                  data: [max1,max2, max3, max4, max5, max6, max7],
                  backgroundColor: "rgba(153,255,51,0.4)"
                  //  backgroundColor: "Red"
                }, {
                  label: 'Min Temp(°C)',
                  data: [min1, min2, min3, min4, min5,min6, min7],
                  backgroundColor: "rgba(255,153,0,0.4)"
                  //  backgroundColor: "Blue"
                }]
              }
            });            
            console.log(request.responseText);
        }       
    }
    else if(request.status==404){
        alert("City not found!!Please provide correct name.");   
    }
}

function grabFile(value) {
    var file;
    var city="";
    city = document.getElementById("city").value;

    if(city==""){
        city = "Athlone";
    }
    
    file = "https://api.openweathermap.org/data/2.5/forecast/daily?q="+city+"&mode=xml&units=metric&cnt=7&appid=9de243494c0b295cca9337e1e96b00e2";
    var request = getHTTPObject();
    if (request){
        request.onreadystatechange= function() {
            tab(request);
        };
        request.open("GET", file, true);
        request.send(null);
    }
}
function grab(value) {
    var file;
    var city="";
    city = document.getElementById("city").value;

    if(city==""){
        city = "Athlone";
    }
    file = "https://api.openweathermap.org/data/2.5/forecast/daily?q="+city+"&mode=xml&units=metric&cnt=7&appid=9de243494c0b295cca9337e1e96b00e2";
    var request = getHTTPObject();
    if (request){
        request.onreadystatechange= function() {
            weat(request);
        };
        request.open("GET", file, true);
        request.send(null);
    }
}
function grabHum(value) {
    var file;
    var city="";
    city = document.getElementById("city").value;

    if(city==""){
        city = "Athlone";
    }
   
    file = "https://api.openweathermap.org/data/2.5/forecast/daily?q="+city+"&mode=xml&units=metric&cnt=7&appid=9de243494c0b295cca9337e1e96b00e2";
    var request = getHTTPObject();
    if (request){
        request.onreadystatechange= function() {
           humid(request);
        };
        request.open("GET", file, true);
        request.send(null);
    }
}


document.addEventListener('DOMContentLoaded', function () {
  var btn = document.getElementById('clickMe');
  var btn2 = document.getElementById('click2');
  var btn3 = document.getElementById('click3');
    var btn4 = document.getElementById('click4');
  if (btn) {
    btn.addEventListener('click', grabFile);
     
  }
  if(btn2){
      btn2.addEventListener('click', grabFile);
      
  }
    if(btn3){
      btn2.addEventListener('click', grab);
        
      
  }
  if(btn3){
      btn2.addEventListener('click', grabHum);
      
  }
})
document.getElementById("clickMe").onclick = grabFile();
document.getElementById("click2").onclick = grabFile();
document.getElementById("click3").onclick = grab();
document.getElementById("click4").onclick = grabHum();

$(document).ready(function(){
    
    $("#clickMe").click(function(){
        $("#aja").show();
        $("#myChart").hide();
        $("#myChart2").hide();
        $("#clickMe").show();
        $("#clickMe2").hide();
        $("#clickMe3").hide();
    });
    $("#click2").click(function(){
        $("#aja").show();
        $("#myChart").hide();
        $("#myChart2").hide();
        $("#clickMe").show();
        $("#clickMe2").hide();
        $("#clickMe3").hide();
    });
    $("#click3").click(function(){
        $("#aja").hide();
        $("#myChart").show();
        $("#myChart2").hide();
        $("#clickMe").hide();
        $("#clickMe2").show();
        $("#clickMe3").hide();
    });
    $("#click4").click(function(){
        $("#aja").hide();
        $("#myChart").hide();
        $("#myChart2").show();
        $("#clickMe").hide();
        $("#clickMe2").hide();
        $("#clickMe3").show();
    });
});
// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("back2Top").style.display = "block";
    } else {
        document.getElementById("back2Top").style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
$(document).ready(function () {
  //your code here

document.getElementById("back2Top").onclick = function topFunction(Event) {
    Event.preventDefault();
    $("html, body").animate({ scrollTop: 0 }, "slow");
    return false;
}
});
 