package exnihilofabrico.common.sieves

import exnihilofabrico.common.base.BaseItem
import exnihilofabrico.common.base.IHasModel
import exnihilofabrico.util.Color
import net.minecraft.client.render.model.UnbakedModel

class MeshItem(val color: Color, settings: Settings): BaseItem(settings), IHasModel {
    override fun getModel(): UnbakedModel {
        //Grab base mesh model
        val baseModel: UnbakedModel
        //Colorize model

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}