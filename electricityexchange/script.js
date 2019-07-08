// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("back2Top").style.display = "block";
    } else {
        document.getElementById("back2Top").style.display = "none";
    }
}

$(document).ready(function(){
   $("#content").load("home.html");        
    
// When the user clicks on the button, scroll to the top of the documen
document.getElementById("back2Top").onclick = function topFunction(Event) {
    Event.preventDefault();
    $("html, body").animate({ scrollTop: 0 }, "slow");
    return false;
}
});


//change pages dynamically using jquery
$('a.dynamic').click(function(){
    var page = $(this).attr('href');
    $("#content").load(page);    
    return false;
});
