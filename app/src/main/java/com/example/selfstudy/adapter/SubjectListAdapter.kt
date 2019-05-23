package com.example.selfstudy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.selfstudy.R
import com.example.selfstudy.model.Subject
import kotlinx.android.synthetic.main.subject_list_item.view.*

class SubjectListAdapter (var mCtx: Context, var resource: Int, var item: List<Subject>) :
    ArrayAdapter<Subject>(mCtx, resource, item){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)

        val view: View = layoutInflater.inflate(resource, null)

        val name: TextView = view.findViewById(R.id.nameSubject)
        val image: ImageView = view.findViewById(R.id.imageSubject)
        val progressBar: ProgressBar = view.findViewById(R.id.progressBar)
        val progressPercent: TextView = view.findViewById(R.id.progressPercent)

        val subject: Subject = item[position]
        name.text = subject.name
        progressBar.progress = subject.progress
        progressPercent.text = subject.progress.toString() + "%"
        image.setImageDrawable(mCtx.resources.getDrawable(subject.image))

        return view
    }
}