package vn.edu.hust.studentman

import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(val students: MutableList<StudentModel>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

  class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener {
    val textStudentName: TextView = itemView.findViewById(R.id.text_student_name)
    val textStudentId: TextView = itemView.findViewById(R.id.text_student_id)

    init {
      itemView.setOnCreateContextMenuListener(this)
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
      menu.add(adapterPosition, 0, 0, "Edit")
      menu.add(adapterPosition, 1, 1, "Remove")
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
    val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_student_item, parent, false)
    return StudentViewHolder(itemView)
  }

  override fun getItemCount(): Int = students.size

  override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
    val student = students[position]
    holder.textStudentName.text = student.studentName
    holder.textStudentId.text = student.studentId
  }

  fun removeStudent(position: Int) {
    students.removeAt(position)
    notifyItemRemoved(position)
    notifyItemRangeChanged(position, students.size)
  }
}
