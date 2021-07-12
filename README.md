# Android-Braille-View

### Description
This is a custom android view that allows you to translate and show directly braille text in a canvas.
Also, in order to make it more readable under the dots the relative alphabet character is displayed.
This view is pretty much flexable because it adjusts the height automatically according to the number of characters that must be displayed and you can customize the background color and the text color.

https://github.com/FrancescoPod/Android-Braille-View/blob/main/img_braille_view.jpeg

### Usage
* Android layout
<...brailleview.BrailleComponents.BrailleView
        android:layout_width="match_parent"
        android:background="@android:color/black"
        android:layout_height="200dp"
        android:layout_marginStart="20dp"
        android:layout_marginEnd="20dp"
        android:layout_marginTop="20dp"
        app:backgroundColor="@color/white"
        app:textColor="@color/black"
        android:id="@+id/brailleView"/>
  * Java
  private BrailleView brailleView;
  brailleView = findViewById(R.id.brailleView);
  brailleView.setText("abc");
  
  ### Contact
  You can contact me at: francesco.podesta03@gmail.com



