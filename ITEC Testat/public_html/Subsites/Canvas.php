<!DOCTYPE html>
<html>
    <head>




        <title>
            ITEC 2014 - Marc Nussbaumer  Canvas Element
        </title>

        <style type="text/css">@import url("../CSS/style.css");</style>
        <link href='../CSS/green.css' rel='stylesheet' type='text/css' />
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <script src="../script.js" type="text/javascript"></script>


        <meta name="author" content="Marc Nussbaumer"> 

        <meta charset="UTF-8">

        <link rel="stylesheet" href="../css/style.css">
        <script type="text/javascript" src="../../JS/PaperLibrary/paper-full.js"></script>
        <script type="text/paperscript" canvas="canvas">
                var width, height, center;
var points = 10;
var smooth = true;
var path = new Path();
var mousePos = view.center / 2;
var pathHeight = mousePos.y;
path.fillColor = 'white';
initializePath();

function initializePath() {
	center = view.center;
	width = view.size.width;
	height = view.size.height / 2;
	path.segments = [];
	path.add(view.bounds.bottomLeft);
	for (var i = 1; i < points; i++) {
		var point = new Point(width / points * i, center.y);
		path.add(point);
	}
	path.add(view.bounds.bottomRight);
	path.fullySelected = true;
}

function onFrame(event) {
	pathHeight += (center.y - mousePos.y - pathHeight) / 10;
	for (var i = 1; i < points; i++) {
		var sinSeed = event.count + (i + i % 10) * 100;
		var sinHeight = Math.sin(sinSeed / 200) * pathHeight;
		var yPos = Math.sin(sinSeed / 100) * sinHeight + height;
		path.segments[i].point.y = yPos;
	}
	if (smooth)
		path.smooth();
}

function onMouseMove(event) {
	mousePos = event.point;
}

function onMouseDown(event) {
	smooth = !smooth;
	if (!smooth) {
		// If smooth has been turned off, we need to reset
		// the handles of the path:
		for (var i = 0, l = path.segments.length; i < l; i++) {
			var segment = path.segments[i];
			segment.handleIn = segment.handleOut = null;
		}
	}
}

// Reposition the path whenever the window is resized:
function onResize(event) {
	initializePath();
}
        </script>
    </head>
    <?php include "Navigation.html"; ?>
    
    <canvas id="canvas"  resize></canvas>
        </div
    </body>
</html>
