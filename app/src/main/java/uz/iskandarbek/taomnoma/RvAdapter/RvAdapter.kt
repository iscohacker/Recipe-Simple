package uz.iskandarbek.taomnoma.RvAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.iskandarbek.taomnoma.User
import uz.iskandarbek.taomnoma.databinding.ItemRvBinding

class RvAdapter(var list: ArrayList<User>, var rvAction: RvAction) : RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(var itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(user: User) {
            itemRv.name.text = user.name
            itemRv.image.setImageResource(user.image)
            itemRv.root.setOnClickListener {
                rvAction.onClick(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        //         Har bitta Item ni yasalishi

        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size
    //            Nechta item yasay


    override fun onBindViewHolder(holder: Vh, position: Int) {
//            Item qiymatlarini beruchi

        holder.onBind(list[position])
    }

    interface RvAction {
        fun onClick(user: User)
    }
}