////Alexander Reid
////Color-Changing Button
void setup() {
  size (640, 480); 
  rectMode (CENTER);
  buttondx = 3;
  buttondy = 2;
}
 float buttonX = 320;
 float buttonY = 240;
 float buttonW = 150;
 float buttonH = 80;
 float R = 100;
 float G = 200;
 float B = 250;
 float buttondx;
 float buttondy;
 
 void draw () {
   background ( R, G, B); 
   rect( buttonX, buttonY, buttonW, buttonH);
   fill(0);
   text ("Click Me!", buttonX-25, buttonY+2);
   fill(255); 
   
   buttonX += buttondx;
   buttonY += buttondy;
 
 if(buttonX>width-20) { buttondx= -buttondx; } //reverses motion when hitting borders
  if(buttonX<1) { buttondx= -buttondx; }

  buttonY=  buttonY + buttondy;  
  if (buttonY<20 || buttonY>height-20) {
    buttondy= -buttondy;
 
 }
 }

void mousePressed (){
 
buttondx = random (-6, +6);
buttondy = random (-4, +4);
  
  
 if ((mouseX < buttonX + buttonW/2) &&
    (mouseX > buttonX - buttonW/2) &&
    (mouseY < buttonY + buttonY/2) &&
    (mouseY > buttonY - buttonY/2))
{
  R = random(255);
  G = random(255);
  B = random (255);
}

}
