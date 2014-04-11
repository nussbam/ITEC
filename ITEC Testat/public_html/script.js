google.load("jquery", "1.3.1");
google.setOnLoadCallback(function()
{
    // Apply some CSS3 to keep the CSS file CSS 2.1 valid
    $("h1").css("text-shadow", "0px 2px 6px #000");
    $("h2 a").css("text-shadow", "0px 2px 6px #000");

    checkCookie();



    // Color changer
    $(".colorblue").click(function() {
        $("link").attr("href", "../CSS/blue.css");
        setCookie("../CSS/blue.css", css, 7);
 
        return false;
    });

    $(".colorgreen").click(function() {
        $("link").attr("href", "../CSS/green.css");
        setCookie("../CSS/green.css", css, 7);
        return false;
    });

    $(".colororange").click(function() {
        $("link").attr("href", "../CSS/orange.css");
        setCookie("../CSS/blue.css", css, 7);
        return false;
    });




    function setCookie(cname, cvalue, exdays)
    {
        var d = new Date();
        d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
        var expires = "expires=" + d.toGMTString();
        document.cookie = cname + "=" + cvalue + "; " + expires;
    }

    function getCookie(cname)
    {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++)
        {
            var c = ca[i].trim();
            if (c.indexOf(name) == 0)
                return c.substring(name.length, c.length);
        }
        return "";
    }

    function checkCookie()
    {
        var css = getCookie("css");
        if (css != "")
        {
             $("link").attr("href", css);
        }
        else
        {
           
                setCookie("../CSS/green.css", css, 7);
            
        }
    }

});