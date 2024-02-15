
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.poparticlestest.core.base.view.BaseViewHolder
import com.example.poparticlestest.main.datasource.entity.Results

abstract class BaseAdapter<T>(
    private var dataList: List<T> = mutableListOf(),
    private var onItemClickListener: IOnItemClickViewHolder
) : RecyclerView.Adapter<BaseViewHolder<T>>() {

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bindingDataInHolder(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    var listData: List<T>
        get() = dataList
        set(listData) {
            this.dataList = listData
            notifyDataSetChanged()
        }
}

interface IOnItemClickViewHolder {
    fun onItemClick(caller: View?, position: Int, id: Results)
}