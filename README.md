# Music Visualiser Project

Name: Ben McCormack

Student Number: C19459424

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment

# Instructions

# How it works

# What I am most proud of in the assignment
I am most proud of the rotating illusion I created with the rectangles in *rectSize.java*. I discovered something similar to this online and was inspired to do my own take on something similar. I started by noting features that I liked about the visual and then also make note of my own features that I would like to implement. The features I wanted to implemement included making the rectangles pulse with the music and change colour with the music. Both of these features were accomplished by using the map function which included getSmoothedAmplitude() method as shown below.

```Java
mv.fill(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);
mv.stroke(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);
```

Scaling the visual with the use of the mouse is another thing that I added to the illusion. Although I liked how it looked initially I began to think of ways to make it more interactive. As the mouse is dragged across the screen, the visual is enlarged which gives the effect that you are now inside the flower like illusion when looking at the screen. The scaling of the visual was done as follows.
```Java
float scaleVar = PApplet.map(mv.mouseX, 0 ,width, (float)0.5,10);
mv.scale(scaleVar);
```
I had to learn a few new things myself throughout this process such as:
 - How to draw a shape from the middle as opposed to the corner as it is drawn by default.
 - How scaling works in processing
 - How to give the effect that shapes were drawn on top of each other when by default you can see the previously drawn shape through the new one.

I spent quite a few hours trying to figure out how to stop the stroke of a previously drawn shape from showing through the new shape and eventually found the following function in the PApplet class which resolved the issue:
```Java
mv.hint(PConstants.DISABLE_OPTIMIZED_STROKE);
```

The visual then went from looking like this:
![An image](images/before.png)

To this:
![An image](images/after.png)

I am really proud of this feature and how the end result turned out. I truly believe that this along with the other elements throughout my program meet the brief requirement of being "Something beautiful to enjoy while listening to music."

Full render method for feature:
```Java
public void render(){
        mv.colorMode(PApplet.HSB);
		mv.strokeWeight(20);
        mv.fill(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0,255), 255, 255);
        mv.stroke(0,15,30);
        mv.background(0,15,30);
        mv.translate(width/2, height/2);
		
        float scaleVar = PApplet.map(mv.mouseX, 0 ,width, (float)0.5,10);
        mv.scale(scaleVar);

        for(int i = 0; i < 100; i++)
        {
            mv.scale((float)0.95);
            mv.rotate(PApplet.radians(angle));
            mv.rect(0,0,500 + mv.getSmoothedAmplitude() * 200 ,500 + mv.getSmoothedAmplitude() * 200);
        }
        angle += 0.05;
    }
```


# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

