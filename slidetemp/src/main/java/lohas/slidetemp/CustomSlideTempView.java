package lohas.slidetemp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;



/**
 * Created by zfw on 2017/02/17.
 */

public class CustomSlideTempView extends View {

    private static final String TAG = "CustomSlideTempView";
    private Paint paint;
    private float downX, moveX, sliderX;
    private float lineH;
    private int screenW, screenH;
    private double minTemp = 18.0, maxTemp = 30.0;
    private float largeRadius = 20f;

    public double currentTempVal = 25.0;

    public CustomSlideTempView(Context context) {
        this(context, null);
    }

    public CustomSlideTempView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomSlideTempView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿
    }

    @Override
    protected void onDraw(Canvas canvas) {
        screenW = getWidth();
        screenH = getHeight();
        lineH = screenH * 2 / 3;

        drawLine(canvas);
        draw0Point(canvas);
        draw1Point(canvas);
        draw2Point(canvas);
        draw3Point(canvas);
        super.onDraw(canvas);
    }

    private void draw0Point(Canvas canvas) {
        float x = 0f;
        float y = lineH;
        double temp = 0.0;
        if (sliderX > 0) {
            x = -screenW / 6;
            temp = currentTempVal - 1;
        }
        if (sliderX < 0) {
            x = screenW * 7 / 6;
            temp = currentTempVal + 1;
        }
        if (temp >= minTemp && temp <= maxTemp) {
            int tempSize=60,symSize=60,alpha =100,xoff = 80,yoff =40,xsym = 40;
            if ((sliderX>screenW/2&&sliderX<screenW*5/6)||(sliderX>-screenW*5/6&&sliderX<-screenW/2)) {
                tempSize =120;
                symSize = 80;
                alpha =255;
                xoff = 120;
                yoff =80;
                xsym = 120;
            }else{
                tempSize =60;
                symSize = 60;
                alpha =100;
                xoff = 80;
                yoff =40;
                xsym = 40;
            }
            paint.setTextSize(tempSize);
            paint.setAlpha(alpha);
            canvas.drawText(String.valueOf(temp), x - xoff + sliderX, y - yoff, paint);
            paint.setTextSize(symSize);
            canvas.drawText("℃",x +xsym+ sliderX,y - yoff, paint);
        }
    }

    private void draw1Point(Canvas canvas) {
        float x = screenW / 6;
        float y = lineH;
        float r = largeRadius / 2;
        double temp = currentTempVal - 0.5;
        paint.setAlpha(255);
        canvas.drawCircle(x, y, r, paint);
        if (sliderX < -screenW / 3) {
            x = screenW * 3 / 2;
            temp = currentTempVal + 1.5;
        }
        if (temp >= minTemp&&temp <= maxTemp) {
            int tempSize=60,symSize=60,alpha =100,xoff = 80,yoff =40,xsym = 40;
            if ((sliderX>screenW/6&&sliderX<screenW/2)||sliderX<-screenW*5/6) {
                tempSize =120;
                symSize = 80;
                alpha =255;
                xoff = 120;
                yoff =80;
                xsym = 120;
            }else{
                tempSize =60;
                symSize = 60;
                alpha =100;
                xoff = 80;
                yoff =40;
                xsym = 40;
            }
            paint.setTextSize(tempSize);
            paint.setAlpha(alpha);
            canvas.drawText(String.valueOf(temp), x - xoff + sliderX, y - yoff, paint);
            paint.setTextSize(symSize);
            canvas.drawText("℃",x + xsym + sliderX,y - yoff, paint);
        }
    }

    private void draw2Point(Canvas canvas) {
        float x = screenW / 2;
        float y = lineH;
        float r = largeRadius;
        double temp = currentTempVal;
        paint.setAlpha(100);
        canvas.drawCircle(x, y, 2 * r, paint);
        paint.setAlpha(255);
        canvas.drawCircle(x, y, r, paint);
        if (sliderX > screenW / 2) {
            x = -screenW * 5 / 6;
            temp = currentTempVal - 2;
        }
        if (sliderX < -screenW / 2) {
            x = screenW * 11 / 6;
            temp = currentTempVal + 2;
        }
        if (temp >= minTemp && temp <= maxTemp) {
            int tempSize=120,symSize=80,alpha = 255,xoff = 120,yoff =80,xsym = 120;
            if (sliderX>-screenW/6&&sliderX<screenW/6) {
                tempSize =120;
                symSize = 80;
                alpha =255;
                xoff = 120;
                yoff =80;
                xsym = 120;
            }else{
                tempSize =60;
                symSize = 60;
                alpha = 100;
                xoff = 80;
                yoff =40;
                xsym = 40;
            }
            paint.setAlpha(alpha);
            paint.setTextSize(tempSize);
            canvas.drawText(String.valueOf(temp), x - xoff + sliderX, y - yoff, paint);
            paint.setTextSize(symSize);
            canvas.drawText("℃",x +xsym+ sliderX,y - yoff, paint);
        }

    }

    private void draw3Point(Canvas canvas) {
        float x = screenW * 5 / 6;
        float y = lineH;
        float r = largeRadius / 2;
        double temp = currentTempVal + 0.5;
        paint.setAlpha(255);
        canvas.drawCircle(x, y, r, paint);
        if (sliderX > screenW / 3) {
            x = -screenW / 2;
            temp = currentTempVal - 1.5;
        }
        if (temp >= minTemp && temp <= maxTemp) {
            int tempSize=60,symSize=60,alpha = 255,xoff = 80,yoff =40,xsym = 40;
            if ((sliderX<-screenW/6&&sliderX>-screenW/2)||sliderX>screenW*5/6) {
                tempSize =120;
                symSize = 80;
                alpha = 255;
                xoff = 120;
                yoff =80;
                xsym = 120;
            }else{
                tempSize =60;
                symSize = 60;
                alpha = 100;
                xoff = 80;
                yoff =40;
                xsym = 40;
            }
            paint.setTextSize(tempSize);
            paint.setAlpha(alpha);
            canvas.drawText(String.valueOf(temp), x - xoff + sliderX, y - yoff, paint);
            paint.setTextSize(symSize);
            canvas.drawText("℃",x +xsym+ sliderX,y - yoff, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = event.getX();
                sliderX = moveX - downX;
                Log.d(TAG, "onTouchEvent: downX=" + downX);
                Log.d(TAG, "onTouchEvent: moveX=" + moveX);
                Log.d(TAG, "onTouchEvent: sliderX=" + sliderX);
                Log.d(TAG, "onTouchEvent: screenW=" + screenW);
                Log.d(TAG, "--------------------------------");
                //右滑
                if (currentTempVal == minTemp && sliderX > 0) {
                    sliderX = 0;
                }
                if (currentTempVal - 0.5 == minTemp && sliderX > screenW / 3) {
                    sliderX = screenW / 3;
                }
                if (currentTempVal - 1 == minTemp && sliderX > screenW * 2 / 3) {
                    sliderX = screenW * 2 / 3;
                }
                if (currentTempVal - 1.5 == minTemp && sliderX > screenW) {
                    sliderX = screenW;
                }
                //左滑
                if (currentTempVal == maxTemp && sliderX < 0) {
                    sliderX = 0;
                }
                if (currentTempVal + 0.5 == maxTemp && sliderX < -screenW / 3) {
                    sliderX = -screenW / 3;
                }
                if (currentTempVal + 1 == maxTemp && sliderX < -screenW * 2 / 3) {
                    sliderX = -screenW * 2 / 3;
                }
                if (currentTempVal + 1.5 == maxTemp && sliderX < -screenW) {
                    sliderX = -screenW;
                }
                invalidate();


                break;
            case MotionEvent.ACTION_UP:
                //右滑
                if (sliderX > screenW / 6 && sliderX < screenW / 2) {
                    currentTempVal = currentTempVal - 0.5;
                    sliderX = screenW / 3;
                }
                if (sliderX > screenW / 2 && sliderX < screenW * 5 / 6) {
                    currentTempVal = currentTempVal - 1;
                    sliderX = screenW * 2 / 3;
                }
                if (sliderX > screenW * 5 / 6) {
                    currentTempVal = currentTempVal - 1.5;
                    sliderX = screenW;
                }
                //左滑
                if (sliderX < -screenW / 6 && sliderX > -screenW / 2) {
                    currentTempVal = currentTempVal + 0.5;
                    sliderX = -screenW / 3;
                }
                if (sliderX < -screenW / 2&& sliderX >-screenW * 5 / 6) {
                    currentTempVal = currentTempVal + 1;
                    sliderX = -screenW * 2 / 3;
                }
                if (sliderX < -screenW * 5 / 6) {
                    currentTempVal = currentTempVal + 1.5;
                    sliderX = -screenW;
                }
                if (sliderX < screenW / 6 && sliderX > -screenW / 6) {
                    sliderX = 0;
                }
                invalidate();
                sliderX = 0;
                break;
        }
        return true;
    }

    /**
     * 绘制横线
     *
     * @param canvas
     */
    private void drawLine(Canvas canvas) {
        int x_s = 0;
        int x_e = screenW;
        //线颜色
        paint.setColor(0xFF06a2c4);
        //圆的边线宽度
        paint.setStrokeWidth(5);
        paint.setAlpha(180);
        canvas.drawLine(x_s, lineH, x_e, lineH, paint);
    }

    public double getCurrentTempVal() {
        return currentTempVal;
    }

    public void setTempSection(double min, double max) {
        minTemp = min;
        maxTemp = max;
        invalidate();
    }
}
