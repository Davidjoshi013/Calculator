package com.davidjoshi.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.davidjoshi.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvClearall.setOnClickListener {
            binding.tvExpression.text = ""
            binding.tvOutput.text = ""
        }
        binding.tvOne.setOnClickListener {
            binding.tvExpression.append("1")
        }
        binding.tvTwo.setOnClickListener {
            binding.tvExpression.append("2")
        }
        binding.tvThree.setOnClickListener {
            binding.tvExpression.append("3")
        }
        binding.tvFour.setOnClickListener {
            binding.tvExpression.append("4")
        }
        binding.tvFive.setOnClickListener {
            binding.tvExpression.append("5")
        }
        binding.tvSix.setOnClickListener {
            binding.tvExpression.append("6")
        }
        binding.tvSeven.setOnClickListener {
            binding.tvExpression.append("7")
        }
        binding.tvEight.setOnClickListener {
            binding.tvExpression.append("8")
        }
        binding.tvNine.setOnClickListener {
            binding.tvExpression.append("9")
        }
        binding.tvPlus.setOnClickListener {
            binding.tvExpression.append("+")
        }
        binding.tvMinus.setOnClickListener {
            binding.tvExpression.append("-")
        }
        binding.tvMultiply.setOnClickListener {
            binding.tvExpression.append("*")
        }
        binding.tvDivide.setOnClickListener {
            binding.tvExpression.append("/")
        }
        binding.tvDot.setOnClickListener {
            binding.tvExpression.append(".")
        }
        binding.tvZero.setOnClickListener {
            binding.tvExpression.append("0")
        }
        binding.tvBackbtn.setOnClickListener {
            val value = binding.tvExpression.text.toString()
            if (value.isNotEmpty()) {
                binding.tvExpression.text = value.substring(0, value.length - 1)
            }
        }
        binding.tvEqual.setOnClickListener {
            val expression = ExpressionBuilder(binding.tvExpression.text.toString()).build()
            val result = expression.evaluate()
            val longresult = result.toLong()
            if (result == longresult.toDouble()) {
                binding.tvOutput.text = longresult.toString()
            } else {
                binding.tvOutput.text = result.toString()
            }
        }
    }
}
