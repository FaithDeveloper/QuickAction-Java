package com.kcs.example.quickactionforjava.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.kcs.example.quickactionforjava.R;
import com.kcs.example.quickactionforjava.quickaction.ActionItem;
import com.kcs.example.quickactionforjava.quickaction.QuickAction;

public class MainActivity extends AppCompatActivity {

    private QuickAction mQuickAction; // == popup menu

    // action id
    private static final int ID_DeletableY = 1;
    private static final int ID_EditableY = 2;
    private static final int ID_SNSArchivingY = 3;
    private static final int ID_SNSArchivingN = 4;
    private static final int ID_SNSReportedY = 5;
    private static final int ID_CANCEL = 6;

    private int selectIdx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuickAction = new QuickAction(this, QuickAction.VERTICAL);
        // Set listener for action item clicked
        mQuickAction.setOnActionItemClickListener(mActionClick);

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionItem deletableItem = new ActionItem(ID_DeletableY,
                        "삭제", null, selectIdx);
                mQuickAction.addActionItem(deletableItem); // add action items into QuickAction.

                ActionItem snsCancel = new ActionItem(ID_CANCEL, "취소", null,
                        selectIdx);
                mQuickAction.addActionItem(snsCancel);

                mQuickAction.show(v);
            }
        });
    }

    private QuickAction.OnActionItemClickListener mActionClick = new QuickAction.OnActionItemClickListener() {

        @Override
        public void onItemClick(QuickAction source, int pos, int actionId, int selectIdx) {
            mQuickAction.dismiss();
        }
    };
}
