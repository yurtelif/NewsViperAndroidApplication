package com.yrtelf.newsviper.databinding;
import com.yrtelf.newsviper.R;
import com.yrtelf.newsviper.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class NewsListItemBindingImpl extends NewsListItemBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public NewsListItemBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private NewsListItemBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[3]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[4]
            );
        this.button.setTag(null);
        this.imageView.setTag(null);
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textView2.setTag(null);
        this.textView3.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.news == variableId) {
            setNews((com.yrtelf.newsviper.model.News) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setNews(@Nullable com.yrtelf.newsviper.model.News News) {
        this.mNews = News;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.news);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.yrtelf.newsviper.model.News news = mNews;
        java.lang.String newsPublishedAt = null;
        boolean newsSaved = false;
        java.lang.String newsTitle = null;
        java.lang.String newsUrlToImage = null;
        java.lang.String newsSavedButtonAndroidStringAlreadyInListButtonAndroidStringAddList = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (news != null) {
                    // read news.publishedAt
                    newsPublishedAt = news.getPublishedAt();
                    // read news.saved
                    newsSaved = news.isSaved();
                    // read news.title
                    newsTitle = news.getTitle();
                    // read news.urlToImage
                    newsUrlToImage = news.getUrlToImage();
                }
            if((dirtyFlags & 0x3L) != 0) {
                if(newsSaved) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }


                // read news.saved ? @android:string/already_in_list : @android:string/add_list
                newsSavedButtonAndroidStringAlreadyInListButtonAndroidStringAddList = ((newsSaved) ? (button.getResources().getString(R.string.already_in_list)) : (button.getResources().getString(R.string.add_list)));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.button, newsSavedButtonAndroidStringAlreadyInListButtonAndroidStringAddList);
            com.yrtelf.newsviper.util.ImageBinding.loadImage(this.imageView, newsUrlToImage);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textView2, newsTitle);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textView3, newsPublishedAt);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): news
        flag 1 (0x2L): null
        flag 2 (0x3L): news.saved ? @android:string/already_in_list : @android:string/add_list
        flag 3 (0x4L): news.saved ? @android:string/already_in_list : @android:string/add_list
    flag mapping end*/
    //end
}