package com.ustc.orange.zax.view.hollow

import android.content.Context
import android.graphics.Canvas
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

/**
 * 绘制的文字问镂空效果的TextView
 * 实现效果时需要给[HollowTextView.setBackground]设置背景
 * 通过 saveLayer + xfermode 实现镂空效果
 */
class HollowTextView(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
  : AppCompatTextView(context, attrs, defStyleAttr) {

  constructor(context: Context) : this(context, null)
  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

  private val canvasArea = RectF()

  init {
    paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
  }

  override fun draw(canvas: Canvas?) {
    if (canvas == null) return super.draw(canvas)
    // 更新画布区域，缓存
    canvasArea.right = width.toFloat()
    canvasArea.bottom = height.toFloat()
    val sc = canvas.saveLayer(canvasArea, null)
    super.draw(canvas)
    canvas.restoreToCount(sc)
  }
}