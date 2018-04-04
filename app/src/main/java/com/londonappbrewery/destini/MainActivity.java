package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private StoryNode mCurrentNode;
    private TextView mStoryTextView;
    private Button mFirstChoiceButton;
    private Button mSecondChoiceButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mFirstChoiceButton = findViewById(R.id.buttonTop);
        mSecondChoiceButton = findViewById(R.id.buttonBottom);

        if(savedInstanceState == null){
            buildStoryTree();
        }else{
            mCurrentNode = savedInstanceState.getParcelable("StoryNode");
        }

        if(mCurrentNode.getEnd() != -1) {
            mStoryTextView.setText(mCurrentNode.getEnd());
            mFirstChoiceButton.setVisibility(View.GONE);
            mSecondChoiceButton.setVisibility(View.GONE);
        }else{
            mStoryTextView.setText(mCurrentNode.getStory());
            mFirstChoiceButton.setText(mCurrentNode.getFirstAnswer());
            mSecondChoiceButton.setText(mCurrentNode.getSecondAnswer());
        }
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mFirstChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveStory(true);
            }
        });

        mSecondChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveStory(false);
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:


    }

    private void moveStory(boolean firstChoice){
        mCurrentNode = firstChoice ? mCurrentNode.getFirstChoice() : mCurrentNode.getSecondChoice();

        if(mCurrentNode.getEnd() != -1) {
            mStoryTextView.setText(mCurrentNode.getEnd());
            mFirstChoiceButton.setVisibility(View.GONE);
            mSecondChoiceButton.setVisibility(View.GONE);

        }else{
            mStoryTextView.setText(mCurrentNode.getStory());
            mFirstChoiceButton.setText(mCurrentNode.getFirstAnswer());
            mSecondChoiceButton.setText(mCurrentNode.getSecondAnswer());
        }

    }

    private void buildStoryTree(){
       StoryNode s1,s2,s3,s4,s5,s6,s7,s8,s9;
       s1 = new StoryNode(R.string.T5_End,-1 , null, null,-1,-1);
       s2 = new StoryNode(R.string.T6_End,-1,null,null,-1,-1);

       s3 = new StoryNode(-1 , R.string.T3_Story, s2, s1,R.string.T3_Ans1, R.string.T3_Ans2);

       s4 = new StoryNode(R.string.T4_End, -1 , null, null, -1, -1);

       s5 = new StoryNode(-1, R.string.T2_Story, s3, s4, R.string.T2_Ans1, R.string.T2_Ans2);

       s6 = new StoryNode(R.string.T6_End, -1, null, null, -1, -1);
       s7 = new StoryNode(R.string.T5_End, -1, null, null , -1, -1);

       s8 = new StoryNode(-1, R.string.T3_Story, s6, s7, R.string.T3_Ans1, R.string.T3_Ans2);

       s9 = new StoryNode(-1, R.string.T1_Story, s8, s5, R.string.T1_Ans1, R.string.T1_Ans2);

       mCurrentNode = s9;

    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putParcelable("StoryNode",mCurrentNode);

    }
}
