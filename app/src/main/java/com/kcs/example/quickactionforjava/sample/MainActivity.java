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
    private static final int ID_ITEM_1 = 1;
    private static final int ID_ITEM_2 = 2;
    private static final int ID_ITEM_3 = 3;
    private static final int ID_ITEM_4 = 4;
    private static final int ID_ITEM_5 = 5;
    private static final int ID_CANCEL = 99;

    private int selectIdx = 0;

    private int[] btnResArray = new int[]{R.id.btn_test, R.id.btn_test1, R.id.btn_test2};
    private int[] itemArray = new int[]{ID_ITEM_1, ID_ITEM_2, ID_ITEM_3, ID_ITEM_4, ID_ITEM_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initOnClickListener();

    }

    /** 클릭 리스너 정의 */
    private void initOnClickListener(){
        for(int res : btnResArray){
            findViewById(res).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mQuickAction.show(v);
                }
            });
        }
    }

    /** 초기 세팅 */
    private void init(){
        mQuickAction = new QuickAction(this, QuickAction.VERTICAL);
        mQuickAction.setOnActionItemClickListener(mActionClick);

//        for(int itemIndex : itemArray) {
//            ActionItem deletableItem = new ActionItem(itemIndex, "ITEM " + (itemIndex), null, selectIdx);
//            mQuickAction.addActionItem(deletableItem); // add action items into QuickAction.
//        }

        ActionItem deletableItem = new ActionItem(ID_ITEM_1, "ITEM 1", null, selectIdx);
            mQuickAction.addActionItem(deletableItem); // add action items into QuickAction.

        ActionItem cancelItem = new ActionItem(ID_CANCEL, "취소", null,selectIdx);
        mQuickAction.addActionItem(cancelItem);
    }

    /** 퀵 버튼 리스너 */
    private QuickAction.OnActionItemClickListener mActionClick = new QuickAction.OnActionItemClickListener() {

        @Override
        public void onItemClick(QuickAction source, int pos, int actionId, int selectIdx) {
            mQuickAction.dismiss();
        }
    };
}
