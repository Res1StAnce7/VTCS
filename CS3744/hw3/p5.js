// function setup (){
//   createCanvas();
//   pixelDensity(1);
//   colorMode(HSB, 1, 1, 1);
//   windowResized();
// }
//
// let points = [];
//
// function init(){
//   points = [];
//   for (let i = 0; i < 100; i++){
//     points.push(createVector(random(width), random(height)));
//   }
// }
//
// function draw(){
//   blendMode(NORMAL);
//   background(0, .01);
//   blendMode(ADD);
//   if (points.length === 0) return;
//
//   stroke((frameCount/100)%1, 1, 1);
//   points[0] = points[0].lerp(createVector(mouseX,mouseY), .5);
//   for (let i = 0; i < points.length-1; i++){
//     let p1 = points[i];
//     let p2 = points[i+1];
//     line(p1.x, p1.y, p2.x, p2.y);
//     p2 = p2.lerp(p1, .5);
//   }
// }
//
// function mousePressed(){windowResized()}
// function windowResized(){
//   resizeCanvas(windowWidth*0.6, windowHeight*0.6);
//   init();
// }
function setup() {
  createCanvas(300, 300);
}

function draw() {
  background('black');
  rect(mouseX, mouseY, 20, 20);
}

