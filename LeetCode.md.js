(function(global, factory) {
    factory();
})(this, function() {
    var _global = typeof window === 'object' && window.window === window ? window : typeof self === 'object' && self.self === self ? self : typeof global === 'object' && global.global === global ? global : void 0;

    function download(url, name, opts) {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', url);
        xhr.responseType = 'blob';
        xhr.onload = function() {
            saveAs(xhr.response, name, opts);
        };
        xhr.onerror = function() {
            console.error('could not download file');
        };
        xhr.send();
    }

    function corsEnabled(url) {
        var xhr = new XMLHttpRequest();
        xhr.open('HEAD', url, false);
        try {
            xhr.send();
        } catch (e) {}
        return xhr.status >= 200 && xhr.status <= 299;
    }

    function click(node) {
        try {
            node.dispatchEvent(new MouseEvent('click'));
        } catch (e) {
            var evt = document.createEvent('MouseEvents');
            evt.initMouseEvent('click', true, true, window, 0, 0, 0, 80, 20, false, false, false, false, 0, null);
            node.dispatchEvent(evt);
        }
    }

    var saveAs = (
        'download' in HTMLAnchorElement.prototype ? function saveAs(blob, name, opts) {
            var URL = (_global.URL && _global.URL.createObjectURL) ? _global.URL : _global.webkitURL;
            var a = document.createElement('a');
            name = name || blob.name || 'download';
            a.download = name;
            a.rel = 'noopener';
                        if (typeof blob === 'string') {
                a.href = blob;
                if (a.origin !== location.origin) {
                    corsEnabled(a.href) ? download(blob, name, opts) : click(a, a.target = '_blank');
                } else {
                    click(a);
                }
            } else {
                a.href = URL.createObjectURL(blob);
                setTimeout(function() {
                    URL.revokeObjectURL(a.href);
                }, 4E4);
                setTimeout(function() {
                    click(a);
                }, 0);
            }
        }
        :
        function saveAs(blob, name, opts, popup) {
            popup = popup || open('', '_blank');
            if (popup) {
                popup.document.title = popup.document.body.innerText = 'downloading...';
            }
            if (typeof blob === 'string') return download(blob, name, opts);
            var force = blob.type === 'application/octet-stream';
            var isSafari = /constructor/i.test(_global.HTMLElement) || _global.safari;
            if ((iforce && isSafari) && typeof FileReader !== 'undefined') {
                var reader = new FileReader();
                reader.onloadend = function() {
                    var url = reader.result.replace(/^data:[^;]*;/, 'data:attachment/file;');
                    if (popup) popup.location.href = url;
                    else location = url;
                    popup = null;
                };
                reader.readAsDataURL(blob);
            } else {
                var URL = _global.URL || _global.webkitURL;
                var url = URL.createObjectURL(blob);
                if (popup) popup.location = url;
                else location.href = url;
                popup = null;
                setTimeout(function() {
                    URL.revokeObjectURL(url);
                }, 4E4);
            }
        });
    function extract() {
        return {
            id: extractTitle(),
            title: extractTitle(),
            href: window.location.href,
            problem: extractProblem(),
            difficulty: extractDifficulty(),
            accepted: extractAccepted(),
            submissions: extractSubmissions(),
            relatedTopics: extractRelatedTags("a[class*=topic-tag]"),
            relatedQuestions: extractRelatedTags("[class*=question] > a[class*=title]")
        }
    }

    function extractTitle() {
        var t = document.querySelector("[data-cy=question-title]");
        return t ? (t.textContent || "").trim() : ""
    }

    function extractProblem() {
        var t = document.querySelector("[class*=question-content] > div");
        if (!t) return "";
        var e = document.createElement("div");
        return e.innerHTML = t.innerHTML, e.querySelectorAll("pre").forEach(t => {
            var e = (t.textContent || "").replace(/^[\r\n]+/, "").replace(/[\r\n]+$/, "").replace(/\u00a0/g, " ");
            t.outerHTML = e ? `\n\n\`\`\`\n${e}\n\`\`\`\n\n` : ""
        }), e.querySelectorAll("strong").forEach(t => {
            var e = (t.textContent || "").trim();
            t.outerHTML = e ? `**${e}**` : ""
        }), e.querySelectorAll("img").forEach(t => {
            var e = t.src,
                r = e.split("/").pop();
            t.outerHTML = `![${r}](${e})\n`
        }), e.querySelectorAll("em").forEach(t => {
            var e = (t.textContent || "").trim();
            t.outerHTML = e ? `*${e}*` : ""
        }), e.querySelectorAll("code").forEach(t => {
            var e = (t.textContent || "").trim();
            t.outerHTML = e ? `\`${e}\`` : ""
        }), e.querySelectorAll("a").forEach(t => {
            var e = (t.textContent || "").trim(),
                r = (t.getAttribute("href") || "").replace(/^\//, "https://leetcode.com/");
            t.outerHTML = `[${e}](${r})`
        }), e.querySelectorAll("ul").forEach(t => {
            let e = "";
            t.querySelectorAll(":scope > li").forEach(t => {
                var r = (t.textContent || "").trim();
                r && (e += `- ${r}\n`)
            }), t.outerHTML = e
        }), e.querySelectorAll("ol").forEach(t => {
            let e = "";
            t.querySelectorAll(":scope > li").forEach((t, r) => {
                var n = (t.textContent || "").trim();
                n && (e += `${r+1}. ${n}\n`)
            }), t.outerHTML = e
        }), e.querySelectorAll("p").forEach(t => {
            var e = (t.textContent || "").trim();
            t.outerHTML = e ? `\n\n${e}\n\n` : ""
        }), e.querySelectorAll("div").forEach(t => {
            var e = (t.textContent || "").trim();
            t.outerHTML = e ? `\n\n${e}\n\n` : ""
        }), (e.textContent || "").replace(/\n\s*\n/g, "\n\n").trim()
    }

    function extractDifficulty() {
        var t = document.querySelector("div[diff]");
        return t ? (t.textContent || "").trim() : ""
    }

    function extractAccepted() {
        var t = document.querySelector("[class*=question-content]").nextElementSibling.querySelector("div > :nth-child(2)");
        return t ? parseInt((t.textContent || "").trim().replace(/,/g, "")) : 0
    }

    function extractSubmissions() {
        var t = document.querySelector("[class*=question-content]").nextElementSibling.querySelector("div:nth-child(2) > :nth-child(2)");
        return t ? parseInt((t.textContent || "").trim().replace(/,/g, "")) : 0
    }

    function extractRelatedTags(t) {
        var e = [];
        return document.querySelectorAll(t).forEach(t => {
            var r = (t.textContent || "").trim(),
                n = (t.getAttribute("href") || "").replace(/^\//, "https://leetcode.com/");
            r && n && e.push({
                title: r,
                href: n
            })
        }), e
    }

    function nFormatter(t) {
        return t >= 1e9 ? (t / 1e9).toFixed(1).replace(/\.0$/, "") + "G" : t >= 1e6 ? (t / 1e6).toFixed(1).replace(/\.0$/, "") + "M" : t >= 1e3 ? (t / 1e3).toFixed(1).replace(/\.0$/, "") + "K" : t
    }

    function renderMarkdown() {
        var t = extract();
        let e = `## [${t.title}](${t.href})\n\n`;
        e += "| Difficulty | Topics | Acceptance | Total Accepted | Total Submissions |\n", e += "| :-: | :-: | --: | --: | --: |\n";
        let r = "";
        t.relatedTopics.forEach(t => r += `, [${t.title.replace(/"/g,'\\"')}](${t.href})`), r = r.substr(2);
        var n = (t.accepted / t.submissions * 100).toFixed(2) + "%",
            o = nFormatter(t.accepted),
            c = nFormatter(t.submissions);
        return e += `| ${t.difficulty} | ${r} | ${n} | ${o} | ${c} |\n\n`, t.problem && (e += "### Problem:\n\n", e += `${t.problem}\n\n`), t.relatedQuestions.length > 0 && (e += "| Similar Questions |\n", e += "| --- |\n", t.relatedQuestions.forEach(t => e += `| [${t.title.replace(/"/g,'\\"')}](${t.href}) |\n`)), e += "\n"
    }

    function data2blob(data, isBase64) {
        var chars = isBase64? atob(data): data;
        var bytes = new Array(chars.length);
        for (var i = 0; i < chars.length; i++) {
            bytes[i] = chars.charCodeAt(i);
        }
        var blob = new Blob([new Uint8Array(bytes)]);
        return blob;
    }

    saveAs(data2blob(renderMarkdown()), "README.md");
});
