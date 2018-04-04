package com.londonappbrewery.destini;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by maroufb on 04/04/2018.
 */

public class StoryNode implements Parcelable {
    private int mEnd;
    private int mStory;
    private StoryNode mFirstChoice;
    private StoryNode mSecondChoice;
    private int mFirstAnswer;
    private int mSecondAnswer;



    public int describeContents(){
        return 0;
    }

    public StoryNode(){
        mEnd = -1;
        mStory = -1;
        mFirstChoice = null;
        mSecondChoice = null;
        mFirstAnswer = -1;
        mSecondAnswer = -1;
    }

    public StoryNode(int end, int story, StoryNode firstChoice, StoryNode secondChoice, int firstAnswer, int secondAnswer){
        mEnd = end;
        mStory = story;
        mFirstChoice = firstChoice;
        mSecondChoice = secondChoice;
        mFirstAnswer = firstAnswer;
        mSecondAnswer = secondAnswer;
    }

    private StoryNode(Parcel in){
        this((StoryNode) in.readParcelable(StoryNode.class.getClassLoader()));
    }

    public StoryNode(StoryNode storyNode){
        mEnd = storyNode.getEnd();
        mStory = storyNode.getStory();
        mFirstChoice = storyNode.getFirstChoice();
        mSecondChoice = storyNode.getSecondChoice();
        mFirstAnswer = storyNode.getFirstAnswer();
        mSecondAnswer = storyNode.getSecondAnswer();
    }

    public static final Parcelable.Creator<StoryNode> CREATOR
            = new Parcelable.Creator<StoryNode>() {
        public StoryNode createFromParcel(Parcel in){
            return new StoryNode(in);
        }

        public StoryNode[] newArray(int size){
            return new StoryNode[size];
        }
    };

    public void writeToParcel(Parcel out, int flags) {
        out.writeParcelable(this,flags);
    }


    public int getEnd() {
        return mEnd;
    }

    public void setEnd(int end) {
        mEnd = end;
    }

    public int getStory() {
        return mStory;
    }

    public void setStory(int story) {
        mStory = story;
    }

    public StoryNode getFirstChoice() {
        return mFirstChoice;
    }

    public void setFirstChoice(StoryNode firstChoice) {
        mFirstChoice = firstChoice;
    }

    public StoryNode getSecondChoice() {
        return mSecondChoice;
    }

    public void setSecondChoice(StoryNode secondChoice) {
        mSecondChoice = secondChoice;
    }

    public int getFirstAnswer() { return mFirstAnswer; }

    public void setFirstAnswer(int firstAnswer) { mFirstAnswer = firstAnswer; }

    public int getSecondAnswer() { return mSecondAnswer; }

    public void setSecondAnswer(int secondAnswer) { mSecondAnswer = secondAnswer; }
}
