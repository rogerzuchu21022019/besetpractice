package nam.rogerzuchu.bestpractice.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nam.rogerzuchu.bestpractice.database.entities.User
import nam.rogerzuchu.bestpractice.databinding.ItemRvBinding

class AppUserAdapter: RecyclerView.Adapter<AppUserAdapter.AppUserViewHolder>() {
    var userList: List<User> = emptyList()
    lateinit var itemRvBinding: ItemRvBinding
    lateinit var layoutInflater: LayoutInflater
    class AppUserViewHolder(itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppUserViewHolder {
        layoutInflater = LayoutInflater.from(parent.context)
        itemRvBinding = ItemRvBinding.inflate(layoutInflater)
        return AppUserViewHolder(itemRvBinding = itemRvBinding)
    }
    fun  setDataForAdapter(userList:List<User>){
        this.userList = userList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AppUserViewHolder, position: Int) {
        var currentUser= userList.get(position)
        itemRvBinding.user = currentUser
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}