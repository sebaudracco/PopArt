package com.example.poparticlestest.main.view.webview

import BaseActivity
import com.example.poparticlestest.databinding.WebviewFragmentBinding


class WebViewActivity
    : BaseActivity<WebviewFragmentBinding>() {

    override fun viewOnReady() {
        super.viewOnReady()
        val url = intent?.extras?.getString("url", "")
        url?.let {
            binding.webView.loadUrl(url)
        }

    }
}

