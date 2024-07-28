package com.example.encoraassignment.utility

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.encoraassignment.localDB.SongsModel
import com.example.encoraassignment.model.Entry
import com.example.encoraassignment.view.activity.MainActivity
import com.example.encoraassignment.view.fragments.DetailFragment
import com.example.encoraassignment.view.fragments.ListFragment

object Utility {
    fun Activity.gotoDetails(item: Entry) {
        val intent = Intent(this, DetailFragment::class.java)
        //intent.putExtra("item",item)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }


    fun List<Entry>?.toSongsModel(): List<SongsModel> {
        val model = this
        return arrayListOf<SongsModel>().apply {
            model?.forEach {
                this.add(it.toSongsModel())
            }
        }
    }

    fun Entry.toSongsModel():SongsModel{
        val model=this
        return SongsModel().apply {
            this.songId=model.entryId
            this.amount=model.imPrice?.amount
            this.currency=model.imPrice?.currency
            this.title=model.title
            this.name=model.imName
            this.categoryId=model.category?.imId
            this.term=model.category?.categoryTerm
            this.label=model.category?.categoryLabel
            this.scheme=model.category?.scheme
            this.image55=model.imImages?.get(0)?.url
            this.image60=model.imImages?.get(1)?.url
            this.image170=model.imImages?.get(2)?.url
            this.artist=model.imArtist
            this.rights=model.rights
            this.releaseDate=model.imReleaseDate
            this.content=model.content
            this.collectionName=model.imCollection?.collectionImName
            this.collectionTerm=model.imCollection?.imContentType?.contentTerm
            this.collectionLabel=model.imCollection?.imContentType?.contentLabel

        }
    }

    fun getTopActivity(): Activity? {
        return GlobalCache.getCurrentActivity()
    }

    fun MainActivity.goToListFrag(
        isFinish: Boolean = false,
        addToBackStack: Boolean = false
    ) {
        navigateFragment(
            act = this,
            fm = this.supportFragmentManager,
            fragment = ListFragment(),
            frameID = this.frameID,
            addToBackStack = addToBackStack,
            isFinish = isFinish,
            isSingleTask = true,
            fromFragment = this.getVisibleFragment()
        )
    }

    fun SongsModel?.goToDetailFrag(
        isFinish: Boolean = false,
        addToBackStack: Boolean = true
    ) {
        getTopActivity()?.let {
            val act=it as MainActivity
            navigateFragment(
                act = act,
                fm = act.supportFragmentManager,
                fragment = DetailFragment(this),
                frameID = act.frameID,
                addToBackStack = addToBackStack,
                isFinish = isFinish,
                isSingleTask = true,
                fromFragment = act.getVisibleFragment()
            )
        }
    }

    fun List<Entry>?.getFirst20():List<Entry>?{
        return this?.take(20)
    }

    fun navigateFragment(
        act: Activity?,
        fm: FragmentManager,
        fragment: Fragment,
        fromFragment: Fragment?,
        frameID: Int,
        addToBackStack: Boolean = false,
        isFinish: Boolean = false,
        bundle: Bundle? = null,
        isSingleTask: Boolean = false
    ) {

        act?.let { ctx ->

            //  fm.commit(true) {
            // fm.beginTransaction().run {
            // setCustomAnimations(R.anim.slide_in_right,
            //    R.anim.slide_out_left,R.anim.slide_in_left,R.anim.slide_out_right)
            var oldFragment: Fragment? = null
            var isFragmentInBackstack = false

            for (i in 0 until fm.backStackEntryCount) {
                val fragAt = fm.getBackStackEntryAt(i)
                if (fragAt.name == fragment.javaClass.simpleName) {

                    isFragmentInBackstack = true
                    break
                }
            }
            if (isSingleTask && isFragmentInBackstack) {
                //oldFragment = fm.findFragmentByTag(fragment.javaClass.simpleName)
                //   if (oldFragment != null) {
                //      fm.beginTransaction().remove(oldFragment).commitAllowingStateLoss()
                //  }
                bundle?.let {
                    fragment.arguments = it
                }
                fm.popBackStack(
                    fragment.javaClass.simpleName,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE
                )

            } else {
                //   oldFragment = fm.findFragmentByTag(fragment.javaClass.simpleName)
                //  if (oldFragment != null) {
                //      fm.beginTransaction().remove(oldFragment).commitAllowingStateLoss()
                //   }

                val trans = fm.beginTransaction()
                /*trans.setCustomAnimations(
                    R.anim.slide_in_right,
                    R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right
                )*/
                bundle?.let {
                    fragment.arguments = it
                }
                trans.replace(frameID, fragment, fragment.javaClass.simpleName)
                if (addToBackStack && !isFinish) {
                    trans.addToBackStack(fromFragment?.javaClass?.simpleName)
                } else if (isFinish) {
                    // if (fromFragment != null) {
                    //     fm.beginTransaction().remove(fromFragment).commitAllowingStateLoss()
                    //  }
                }

                //   fm.beginTransaction().remove(fromFragment).commitAllowingStateLoss()
                trans.commitAllowingStateLoss()
                //   if(isFinish){
                //      fm.popBackStack(fromFragment?.javaClass?.simpleName, 0)
                //  }
                //  if(isFinish && fromFragment != null){
                // (act as? MPBaseScreen)?.supportFragmentManager?.beginTransaction()?.remove(fromFragment)?.commitAllowingStateLoss()
                //   }
            }
        }

    }

}