void setup() {
  size (640, 480); 
  rectMode (CENTER);
}
 float buttonX = 320;
 float buttonY = 240;
 float buttonW = 150;
 float buttonH = 80;
 float R = 100;
 float G = 200;
 float B = 250;
 
 void draw () {
   background ( R, G, B); 
   rect( buttonX, buttonY, buttonW, buttonH);
   fill(0);
   text ("Click Me!", buttonX-25, buttonY+2);
   fill(255); 
 }

void mousePressed (){
 
 if ((mouseX < buttonX + buttonW/2) &&
    (mouseX > buttonX - buttonW/2) &&
    (mouseY < buttonY + buttonY/2) &&
    (mouseY > buttonY - buttonY/2))
{
  R = random(50, 150);
  G = random( 20, 70);
  B = random (100, 255);
}

}
