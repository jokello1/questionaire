package com.example.questionaire;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.questionaire.Model.Questionnaire;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "";
    EditText edtName, edtGender, edtYearStudy, edtAdmissionYear,
            edtHaveBus, edtBusNature, edtIntrstOnlineBus, edtIntrstToSell,
            edtNatureOfProd, edtSuccessStatus, edtSuccessHindrance, edtTimesSuccessSale,
            edtSellValue, edtIntrstToOnlineSellStdnt, edtNewsFan, edtTopicsIntrst,
            edtLocalNewsSource, edtComprehensive, edtWhatsMissing, edtEffectOpinion,
            edtVisitFrequency, edtWhyNot;
    Button btnSubmit,mbmmb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.name_id);
        edtGender = findViewById(R.id.gender_id);
        edtYearStudy = findViewById(R.id.yearStudy_id);
        edtAdmissionYear = findViewById(R.id.yearAdmission_id);
        edtHaveBus = findViewById(R.id.ifHaveBus_id);
        edtBusNature = findViewById(R.id.natureOfBiz_id);
        edtIntrstOnlineBus = findViewById(R.id.onlineStatus_id);
        edtIntrstToSell = findViewById(R.id.itrstSelinToStdnt_id);
        edtNatureOfProd = findViewById(R.id.itemIntetSell_id);
        edtSuccessStatus = findViewById(R.id.statusOfSuccess_id);
        edtSuccessHindrance = findViewById(R.id.successHindrance_id);
        edtTimesSuccessSale = findViewById(R.id.timesSoldItem_id);
        edtSellValue = findViewById(R.id.sellValue_id);
        edtIntrstToOnlineSellStdnt = findViewById(R.id.interstSellingOnlineStdnt_id);
        edtNewsFan = findViewById(R.id.newsFan_id);
        edtTopicsIntrst = findViewById(R.id.favouriteNews_id);
        edtLocalNewsSource = findViewById(R.id.sourceOfNews_id);
        edtComprehensive = findViewById(R.id.comprehensiveness_id);
        edtWhatsMissing = findViewById(R.id.whatsMissing_id);
        edtEffectOpinion = findViewById(R.id.effectOpinion_id);
        edtVisitFrequency = findViewById(R.id.visitBoard_id);
        edtWhyNot = findViewById(R.id.whyNot_id);
        btnSubmit = findViewById(R.id.submit);

        //Init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference questionnaire_user = database.getReference("questionaire");


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(MainActivity.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();
                questionnaire_user.addValueEventListener(new ValueEventListener() {
                    String name = edtName.getText().toString().trim();
                    String gender = edtGender.getText().toString().trim();
                    String yearOfStudy = edtYearStudy.getText().toString().trim();
                    String admissionYear = edtAdmissionYear.getText().toString().trim();
                    String haveABusiness = edtHaveBus.getText().toString().trim();
                    String natureOfBusiness = edtBusNature.getText().toString().trim();
                    String interestInOnlineBussiness = edtIntrstOnlineBus.getText().toString().trim();
                    String interestToSell = edtIntrstToSell.getText().toString().trim();
                    String natureOfProduct = edtNatureOfProd.getText().toString().trim();
                    String successStatus = edtSuccessStatus.getText().toString().trim();
                    String successHindrance = edtSuccessHindrance.getText().toString().trim();
                    String timesSuccessfulSale = edtTimesSuccessSale.getText().toString().trim();
                    String sellValue = edtSellValue.getText().toString().trim();
                    String intrestToOnlineSellStudent = edtIntrstToOnlineSellStdnt.getText().toString().trim();
                    String newsFan = edtNewsFan.getText().toString().trim();
                    String topicsOfInterest = edtTopicsIntrst.getText().toString().trim();
                    String sourceOfNews = edtLocalNewsSource.getText().toString().trim();
                    String comprehensiveness = edtComprehensive.getText().toString().trim();
                    String whatsMissing = edtWhatsMissing.getText().toString().trim();
                    String effectOpinion = edtEffectOpinion.getText().toString().trim();
                    String visitFrequency = edtVisitFrequency.getText().toString().trim();
                    String whyNot = edtWhyNot.getText().toString().trim();

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        mDialog.dismiss();
                        Questionnaire questionaire = new Questionnaire(name, gender, yearOfStudy, admissionYear, haveABusiness, natureOfBusiness, interestInOnlineBussiness, interestToSell, natureOfProduct,
                                successStatus, successHindrance, timesSuccessfulSale, sellValue, intrestToOnlineSellStudent, newsFan, topicsOfInterest, sourceOfNews, comprehensiveness, whatsMissing,
                                effectOpinion, visitFrequency, whyNot);
                        questionnaire_user.child(name).setValue(questionaire);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
