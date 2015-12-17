////Alexander Reid
///CST-112-Eve

float horizon;
int score;
float boatX=0, boatDX=5;
float waterR, waterG, waterB;
float left, right, top, bottom;
String [] jellyNames = {
  "Ali", "Finn", "Lou", "Amy", "Shai",
};
String [] boatNames  = {
  "Zeta", "Beta", "Gamma", "Theta", "Lambda"
};
String [] lobsterNames = {
  "Boo", "June", "Flynn", "Don", "Pam"
};
Jelly [] school; //array of object: jellyfish
Boat [] fleet; //array of object: boats
Lobster [] ajr; //array of object: lobster
Sun shine; //object: sun

void setup() {
  size(800, 600);
  horizon = height/4;
  left = 50;
  right = width-50;
  top = horizon;
  bottom = height-50;
  reset();
}
void reset() {
  score = 0;
  shine = new Sun(); //object: sun
  school = new Jelly[5]; //initialize array: jellyfish
  float jellyX = width/4;
  float lobsterX = width/4;
  for (int i=0; i<school.length; i++) {
    school[i] = new Jelly(jellyX, jellyNames[i]);
    jellyX += 145;
  }
  fleet = new Boat[5]; //initalize array: boats
  for (int i=0; i<fleet.length; i++) {
    fleet[i] = new Boat(boatNames[i]);
  }
  ajr = new Lobster[5]; //initialize array: lobster
  for (int i=0; i<ajr.length; i++) {
    ajr[i] = new Lobster(lobsterX, lobsterNames[i]);
  }
}
void draw() {
  background(140, 197, 234);
  scene();
  display();
  messages();
  if (key >= 'A' && key <= 'Z') {
    jellyScore(school, school.length);
    boatScore(fleet, fleet.length);
    lobsterScore(ajr, ajr.length);
  } else {

    action();
  }
}

void jellyScore(Jelly[] a, int m) { //scorecards for jellyfish
  float x = width/4-100;
  float y = height/4-100;
  float w = width/4*1.7;
  float h = height/4*1.7;
  fill(255);
  rect(x-20, y-30, w, h);
  fill(0, 0, 0);
  textSize(15);
  text("Jelly Scores!", x+100, y);
  textSize(10);
  text("Name", x, y+20);
  text("Legs", x+75, y+20);
  text("X", x+140, y+20);
  text("Y", x+215, y+20);
  text("DY", x+275, y+20);
  for (int i=0; i<m; i++) {
    fill(0);
    text(a[i].name, x, y+40);
    text(a[i].legs, x+75, y+40);
    text(a[i].x, x+140, y+40);
    text(a[i].y, x+215, y+40);
    text(a[i].dy, x+275, y+40);
    y += 35;
  }
}



void boatScore(Boat[]a, int m) { //scorecards for boats
  float x = width/2-100;
  float y = height/2+10;
  float w = width/2-50;
  float h = height/2-20;
  fill(100);
  rect(x-20, y-30, w, h);
  fill(255);
  textSize(15);
  text("Boat Scores!", x+100, y);
  textSize(10);
  text("Name", x, y+20);
  text("Cargo", x+75, y+20);
  text("X", x+175, y+20);
  text("DX", x+275, y+20);
  for (int i=0; i<m; i++) {
    text(a[i].name, x, y+40);
    text(a[i].cargo, x+75, y+40);
    text(a[i].x, x+175, y+40);
    text(a[i].dx, x+275, y+40);
    y += 45;
  }
}
void lobsterScore(Lobster[]a, int m) { //scorecards for lobsters
  float x = width/6+320;
  float y = height/6-85;
  float w = width/2-50;
  float h = height/2-20;
  fill(100);
  rect(x-20, y-30, w, h);
  fill(255);
  textSize(15);
  text("Lobster Scores", x+100, y);
  textSize(10);
  text("Name", x, y+20);
  text("X", x+90, y+20);
  text("DX", x+275, y+20);
  text("Y", x+175, y+20);
  text("DY", x+230, y+20);
  for (int i=0; i<m; i++) {
    text(a[i].name, x, y+40);
    text(a[i].x, x+90, y+40);
    text(a[i].dx, x+275, y+40);
    text(a[i].y, x+175, y+40);
    text(a[i].dy, x+230, y+40);
    y += 45;
  }
}
void action() {
  for (int i=0; i<school.length; i++) { //moves jellyfish
    school[i].move();
  }
  for (int i=0; i<fleet.length; i++) { //moves boats
    fleet[i].move();
  }
  for (int i=0; i<ajr.length; i++) { //moves lobster
    ajr[i].move();
  }
}
void scene() {
  noStroke();
  fill(103, 127, 209);
  rect(0, horizon, width, height); //water
  stroke(0);

  for (int i=0; i<school.length; i++) { //shows jellyfish
    school[i].show();
  }
  for (int i=0; i<fleet.length; i++) { //shows boats
    fleet[i].show();
  }
  for (int i=0; i<ajr.length; i++) { //shows lobster
    ajr[i].show();
  }
  shine.show();
  shine.move();
}
void messages() {
  textSize(13);
  fill(0);
  text("Alexander Reid", width/4-180, horizon+440);
  text ("Score", width*3/4, horizon-80);
  text(score, width*3/4 +50, horizon - 80);
  text("Final Exam", width*3/4, horizon - 100);
  text("Press 'r' to reset", width/4-180, horizon -85);
  text("Shift & any key for Scores", width/4-180, horizon-105);
  textSize(11);
}

void sortJellyX(Jelly[] a, int many) {

  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].x > a[k].x) k = j;
    }
    swapJelly(a, m-1, k);
  }
}

void sortJellyY(Jelly[] a, int many) { //sort by jelly height
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].y > a[k].y) k = j;
    }
    swapJelly(a, m-1, k);
  }
}

void sortJellyDY(Jelly[] a, int many) {// sort by jelly speed
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].dy > a[k].dy) k = j;
    } 
    swapJelly(a, m-1, k);
  }
}

void sortJellyLegs(Jelly[] a, int many) { // sort by jelly legs
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].legs > a[k].legs) k = j;
    }
    swapJelly(a, m-1, k);
  }
}


void swapJelly(Jelly[] a, int k, int j) { //swap jelly position, legs, speed and name
  Jelly tmp;

  tmp = a[k];
  a[k] = a[j];
  a[j] = tmp;
}


void sortBoatX(Boat[] a, int many) { //sort by x
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].x > a[k].x) k = j;
    }
    swapBoat(a, m-1, k);
  }
}


void sortBoatDX(Boat[] a, int many) { //sort by dx
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].dx < a[k].dx) k = j;
    }
    swapBoat(a, m-1, k);
  }
}


void sortBoatCargo(Boat[] a, int many) { //sort by cargo
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].cargo < a[k].cargo) k = j;
    }
    swapBoat(a, m-1, k);
  }
}


void swapBoat(Boat[] a, int k, int j) { //swap position, speed and cargo
  Boat tmp;

  tmp = a[k];
  a[k] = a[j];
  a[j] = tmp;
}

void keyPressed() {
  if (key == 'r') {
    reset();
  }
  if (key == 'x') {
    sortJellyX(school, school.length);
  }
  if (key == 'y') {
    sortJellyY(school, school.length);
  }
  if (key == 'f') {
    sortBoatCargo(fleet, fleet.length);
  }
  if (key == 's') {
    sortJellyDY(school, school.length);
  }
  if (key == 'b') {
    sortBoatX(fleet, fleet.length);
  }
  if (key == 'b') {
    sortJellyLegs(school, school.length);
  }
  if (key == 'b') {
    sortBoatDX(fleet, fleet.length);
  }
}

class Jelly { //class: jellyfish
  float x, y, dx, dy;
  float r, g, b;
  int legs = 8;
  int count = 0;
  String name = "";

  Jelly(float x, String name) {
    this.name = name;
    this.x = x;
    r = random(255);
    g = random(255);
    b = random(255);
    seaFloor();
  }
  void seaFloor() {
    y = height - 20;
    dy = -random(0.2, 2);
    legs = int(random(1, 6));
  }

  void show() { //shows jellies
    count++;
    noStroke();
    fill(r, g, b);
    ellipse(x-70, y, 40, 40);
    rect(x-90, y, 40, 20);
    fill(0);
    text(name, x-80, y);  //jelly names
    text(legs, x-75, y +10); //number of legs

    strokeWeight(3);
    stroke(random(255));
    float legX = x-18; //actual legs
    for (int i=0; i<legs; i++) {
      if (count/30 % 2 == 0) {
        line(legX-70, y+20, legX-80, y+45);
      } else {
        line(legX-70, y+20, legX-60, y+45);
      }
      legX +=8; //spacing between legs

      stroke(random(255));
      strokeWeight(3);
    }
  }

  void move() { //moves jellies
    y += dy;
    if (y < horizon || y > height) dy*= -1;
  }
}



class Boat { //class: boat
  float x, y, dx;
  float r, g, b;
  String name = "";
  int cargo=0, caught=0;

  Boat(String name) {
    this.name = name;
    x= random(30, width - 60);
    y = horizon - 25;
    dx = random(-6, 6);
    r = random(255);
    g = random(255);
    b = random(255);
  }

  void show() {
    noStroke(); 
    fill(r, g, b); 
    rect(x, y, 50, 25);// body 
    if (dx < 0) { 
      triangle( x, y+25, x - 20, y, x, y); // front 
      rect(x, y - 20, 30, 30); // cabin 
      fill(0); 
      text(cargo, x + 10, y - 5); // display cargo
    } else { 
      triangle( x+49, y+25, x + 70, y, x+49, y); 
      rect(x+20, y - 20, 30, 30); // cabin 
      fill(0); 
      text(cargo, x + 30, y - 5); // display cargo
    } 
    stroke(0); 
    fill(0); 
    text(name, x, y + 15);  // display boat name
  }
  void move() {
    x += dx;
    if (x < 25 || x > width - 75) dx *= -1;


    for (int i = 0; i < school.length; i++) { 
      if (dist(x, y, school[i].x, school[i].y) < 50) { //catch jelly
        cargo += school[i].legs; 
        school[i].seaFloor(); //sends to bottom, random legs
      }
    } 

    if (x < 25) { 
      caught += cargo; //cargo = caught
      cargo = 0; 
      score += caught;
    }
  }
} 

class Sun { //class: sun
  float x, y, dx; 
  float r, g, b; 


  Sun() { 
    x = width*3/4; 
    y = height/4 - 100; 
    dx = 1; 
    r = 222; 
    g = 113; 
    b = 63;
  } 


  void show() {  
    noStroke();
    fill(r, g, b); 
    ellipse(x, y, 60, 60); 
    stroke(0);
  } 

  void move() { //moves sun
    x += dx;  
    if (x > width + 200) x = 0;
  }
}

class Lobster { //class: lobster
  float x, y, dx, dy;
  float r, g, b;
  int count = 0;
  String name = "";

  Lobster(float x, String name) {
    this.name = name;
    this.x = x;
    x= width/8;
    y = horizon +100;
    dx = random(1, 3);
    dy = random(-6, 6);
    r = random(255);
    g = random(255);
    b = random(255);
  }
  void show () { //shows "lobsters"
    fill(r, g, b);
    ellipse(x, y, 70, 50);
  }

  void move () { //moves lobsters

    x += dx;  
    if ( x<left || x>right ) dx *= -1;
    y += dy;  
    if ( y<top || y>bottom ) dy *=  -1;
    
  }
}

void display () {
  float tri = 0;
  fill(255, 0, 0);
  while (tri < height) {
    triangle(width -15, horizon+tri, width-15, horizon+(tri+20), width-30, horizon+(tri+10));
    tri += 60;
}
}
