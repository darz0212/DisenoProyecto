package co.edu.konradlorenz.tucomida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class OrderActivity extends AppCompatActivity {

    private EditText quantity;
    private TextView aproxPrice,domicilePrice, total;
    private Button confirmOrderBtn, cancelOrderBtn;
    private Dish dishItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Bundle parameters = getIntent().getExtras();

        if(parameters != null){
            dishItem = (Dish) parameters.get("dishOrder");

            quantity = (EditText) findViewById(R.id.totalDishesEditText);
            aproxPrice = (TextView) findViewById(R.id.aproxPriceOrder);
            domicilePrice = (TextView) findViewById(R.id.domicileTextView);
            total = (TextView) findViewById(R.id.totalTextView);

            confirmOrderBtn = (Button) findViewById(R.id.orderConfirmButton);
            cancelOrderBtn = (Button) findViewById(R.id.orderCancelButton);


            int count = 1;
            DecimalFormat formatea;
            float totalAprox = dishItem.getApproximatePrice()*count;
            formatea = new DecimalFormat("###,###.##");
            String formatedPrice = formatea.format(totalAprox);
            aproxPrice.setText("$"+formatedPrice);

            String domicileFormated = formatea.format(5000);
            domicilePrice.setText("$"+domicileFormated);

            float totalPrice = totalAprox + 5000;
            String totalFormated = formatea.format(totalPrice);
            total.setText("$"+totalFormated);

            quantity.addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (quantity.getText().length() >= 0) {
                        int count = Integer.parseInt(String.valueOf(quantity.getText()));
                        DecimalFormat formatea;
                        float totalAprox = dishItem.getApproximatePrice() * count;
                        formatea = new DecimalFormat("###,###.##");
                        String formatedPrice = formatea.format(totalAprox);
                        aproxPrice.setText("$" + formatedPrice);

                        String domicileFormated = formatea.format(5000);
                        domicilePrice.setText("$" + domicileFormated);

                        float totalPrice = totalAprox + 5000;
                        String totalFormated = formatea.format(totalPrice);
                        total.setText("$" + totalFormated);
                    }
                }
            });

            confirmOrderBtn.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View view) {
                    Toast.makeText(OrderActivity.this,"Su pedido llegara lo mas pronto posible, !Gracias por su compra¡ ",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent ( OrderActivity.this, DishesListActivity.class );
                    startActivity ( intent );
                }
            } );

            cancelOrderBtn.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent ( OrderActivity.this, DishesListActivity.class );
                    startActivity ( intent );
                }
            } );
        }
    }
}
