package francesco.podesta03.brailleview.BrailleComponents;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BrailleView extends View {
    Context context;
    private String text;
    private Canvas canvas;
    //private ArrayList<Letter> letters;
    private Paint paint;
    private Paint textPaint;
    final float circleRadius = (float)12;
    final float emptyCircleRadius = 5;
    final float circleSpacing = 40;
    final float cardSpacing = 120;
    final float cardDimX = 64;
    final float cardDimY = 104;
    private int mX;
    private int mY;
    final float wordsSpacing = 128;
    final Point startPoint = new Point((int)cardDimX,(int)cardDimX);
    final int sizeX = 2;
    final int sizeY = 3;
    private int backgroundColor;
    private int textColor;







    public BrailleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        int bgColor = attrs.getAttributeResourceValue("http://schemas.android.com/apk/res-auto","backgroundColor", Color.WHITE);
        int txtColor = attrs.getAttributeResourceValue("http://schemas.android.com/apk/res-auto", "textColor", Color.BLACK);
        try{
            backgroundColor = getResources().getColor(bgColor);
        }catch(Exception e){
            backgroundColor = bgColor;
        }
        try{
            textColor = getResources().getColor(txtColor);

        }catch(Exception e){
            textColor = txtColor;

        }

        //letters = new ArrayList<>();
        paint = new Paint();
        paint.setColor(textColor);
        textPaint = new Paint();
        textPaint.setColor(textColor);
        textPaint.setTextSize(60);
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;




}
    public void setText(String text){
        this.text = text;
        this.invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mX = getMeasuredWidth();
        mY = getMeasuredHeight();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mX = w;
        mY = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            canvas.drawColor(backgroundColor);
            // calculate available cards
            int availableCards = (int) Math.floor(mX / (cardDimX * 2));
            //System.out.println(availableCards);
            int startHeight = startPoint.y + (int) cardDimY + startPoint.y + (int) cardDimY * 1 / 4;
            System.out.println(startHeight);
            int counter = 0;
            int height_counter = 1;
            int width_counter = 0;
            setHeight(startHeight);
            // draw all the characters
            if(text != null) {
                String[] letters = text.split("");
                for (int i = 0; i < letters.length; i++) {
                    translate(letters[i], startPoint.x + (int) cardSpacing * width_counter, startPoint.y + (int) cardDimY * 2 * (height_counter - 1), canvas);
                    width_counter++;
                    counter++;
                    if (counter >= availableCards) {
                        counter = 0;
                        height_counter++;
                        width_counter = 0;
                        setHeight((int)Math.floor((cardDimY+cardSpacing)*height_counter));
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

//        test draw

//        canvas.drawCircle(100,100,circleRadius,paint);
//        canvas.drawCircle((float)100,(float)100+circleSpacing,(float)circleRadius,paint);
//        canvas.drawCircle(100,(float)100+circleSpacing+circleSpacing,(float)circleRadius,paint);
//        canvas.drawCircle(100+circleSpacing,100,circleRadius,paint);
//        canvas.drawCircle(100+circleSpacing,100+circleSpacing,circleRadius,paint);
//        canvas.drawCircle(100+circleSpacing,100+circleSpacing+circleSpacing,circleRadius,paint);
//
//        canvas.drawCircle(100+cardSpacing,100,circleRadius,paint);
//        canvas.drawCircle((float)100+cardSpacing,(float)100+circleSpacing,(float)circleRadius,paint);
//        canvas.drawCircle(100+cardSpacing,(float)100+circleSpacing+circleSpacing,(float)circleRadius,paint);
//        canvas.drawCircle(100+circleSpacing+cardSpacing,100,circleRadius,paint);
//        canvas.drawCircle(100+circleSpacing+cardSpacing,100+circleSpacing,circleRadius,paint);
//        canvas.drawCircle(100+circleSpacing+cardSpacing,100+circleSpacing+circleSpacing,circleRadius,paint);




    }
    private void translate(String letter, int x, int y, Canvas canvas){
        Point startPoint = new Point(x,y);
        letter = letter.toLowerCase();
        // map all the letters
        switch (letter) {
            case "a": {
                float[][] points = {{1, 0}, {0, 0}, {0, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "b": {
                float[][] points = {{1, 0}, {1, 0}, {0, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "c": {
                float[][] points = {{1, 1}, {0, 0}, {0, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "d": {
                float[][] points = {{1, 1}, {0, 1}, {0, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "e": {
                float[][] points = {{1, 0}, {0, 1}, {0, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "f": {
                float[][] points = {{1, 1}, {1, 0}, {0, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "g": {
                float[][] points = {{1, 1}, {1, 1}, {0, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "h": {
                float[][] points = {{1, 0}, {1, 1}, {0, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "i": {
                float[][] points = {{0,1},{1,0},{0,0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "j": {
                float[][] points = {{0, 1}, {1, 1}, {0, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "k": {
                float[][] points = {{1, 0}, {0, 0}, {1, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "l": {
                float[][] points = {{1, 0}, {1, 0}, {1, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "m": {
                float[][] points = {{1, 1}, {0, 0}, {1, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "n": {
                float[][] points = {{1, 1}, {0, 1}, {1, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "o": {
                float[][] points = {{1, 0}, {0, 1}, {1, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "p": {
                float[][] points = {{1, 1}, {1, 0}, {1, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "q": {
                float[][] points = {{1, 1}, {1, 1}, {1, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "r": {
                float[][] points = {{1, 0}, {1, 1}, {1, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "s": {
                float[][] points = {{0, 1}, {1, 0}, {1, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "t": {
                float[][] points = {{0, 1}, {1, 1}, {1, 0}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "u": {
                float[][] points = {{1, 0}, {0, 0}, {1, 1}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "w": {
                float[][] points = {{0,1},{1,1},{0,1}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "v": {
                float[][] points = {{1, 0}, {1, 0}, {1, 1}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "x": {
                float[][] points = {{1, 1}, {0, 0}, {1, 1}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "y": {
                float[][] points = {{1, 1}, {0, 1}, {1, 1}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
            case "z": {
                float[][] points = {{1, 0}, {0, 1}, {1, 1}};
                drawLetter(canvas, points, startPoint, letter);
                break;
            }
        }
    }
    private void drawLetter(Canvas canvas, float[][] points, Point startPoint, String letter){
        // draw dots and the relative character below
        for(int i = 0; i<sizeY;i++){
            for(int j = 0; j<sizeX; j++){
                if(points[i][j] == 1){
                    // draw a full point
                    canvas.drawCircle(startPoint.x+circleSpacing*j,startPoint.y+circleSpacing*i,circleRadius,paint);
                }
                else{
                    // draw an empty point
                    canvas.drawCircle(startPoint.x+circleSpacing*j,startPoint.y+circleSpacing*i,emptyCircleRadius,paint);
                }

            }
        }
        canvas.drawText(letter,startPoint.x+6,startPoint.y+cardDimY+40,textPaint);
    }
    private void setHeight(int height){
        ViewGroup.LayoutParams params = this.getLayoutParams();
        params.height = height;
        this.requestLayout();
    }
}
