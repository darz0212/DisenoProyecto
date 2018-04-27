package co.edu.konradlorenz.tucomida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;

public class DishDetailActivity extends AppCompatActivity {

    public TextView name, ingredients, preparationTime, difficulty, steps, approximatePrice;
    public ImageView thumbnail, video;

    Button btnOrder;

    private Dish dishItem;
    public TextView comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_detail);

        Bundle parameters = getIntent().getExtras();

        if(parameters != null){
            dishItem = (Dish) parameters.get("dishItem");

            name = (TextView) findViewById(R.id.dishNameTextView);
            ingredients = (TextView) findViewById(R.id.ingredientsTextView);
            preparationTime = (TextView) findViewById(R.id.timeTextView);
            difficulty = (TextView) findViewById(R.id.dificultTextView);
            steps = (TextView) findViewById(R.id.stepsTextView);
            approximatePrice = (TextView) findViewById(R.id.aproxValueTextView);

            comments = (TextView) findViewById(R.id.registerLinkTextView);
            btnOrder = (Button) findViewById ( R.id.ingredientsConfirmButton );

            thumbnail = (ImageView) findViewById(R.id.dishImage);
            video = (ImageView) findViewById(R.id.dishVideo);

            DecimalFormat formatea;
            formatea = new DecimalFormat("###,###.##");
            String formatedPrice = formatea.format(dishItem.getApproximatePrice());

            name.setText(dishItem.getName());
            ingredients.setText(dishItem.getIngredients()+"");
            preparationTime.setText(dishItem.getPreparationTime()+"");
            difficulty.setText(dishItem.getDifficulty()+"");
            steps.setText(dishItem.getSteps()+"");
            approximatePrice.setText("$"+formatedPrice);

            Glide.with(this).load(dishItem.getThumbnail()).into(thumbnail);
            Glide.with(this).load(dishItem.getVideo()).into(video);


            btnOrder.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent ( DishDetailActivity.this, OrderActivity.class );
                    intent.putExtra("dishOrder", dishItem);
                    startActivity ( intent );
                }
            } );

            comments.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent ( DishDetailActivity.this, CommentsActivity.class );
                    intent.putExtra("dishItemComments", dishItem);
                    startActivity ( intent );
                }
            } );
        }
    }
}
