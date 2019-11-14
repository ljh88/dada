/**
 * Created by fenghao1 on 2017/1/5.
 */
var chineseCharactersPinyin = {};

function chineseCharactersToPinyinAndFirstCharsWithCache(ch) {
    var pinyin = chineseCharactersPinyin[ch];
    if (typeof pinyin == 'undefined') {
        pinyin = chineseCharactersToPinyinAndFirstChars(ch);
        chineseCharactersPinyin[ch] = pinyin;
    }
    return pinyin;
}

// 依赖https://github.com/xinglie/pinyin
function chineseCharactersToPinyinAndFirstChars(ch) {
    var pinyinArray = Utils.CSpell.getPolyphoneSpell(ch);
    var pinyins = pinyinArray.map(function(item,index,array){
        if (item.length >= 0) {
            return item.join('');
        } else {
            return '';
        }
    }).join(' ');
    var firstChars = [];
    for (var i = 0; i < pinyinArray.length; i++) {
        var s = '';
        for (var j = 0; j < pinyinArray[i].length; j++) {
            var word = pinyinArray[i][j];
            if (word.length > 0) {
                s += word.substring(0, 1);
            }
        }
        if (firstChars.indexOf(s) == -1) {
            firstChars.push(s);
        }
    }
    return $.trim(pinyins + ' ' + firstChars.join(' '));
}

function select2ForPinyinOrChineseCharacters(selector, placeholder, options, defaultValue) {
    $.fn.select2.amd.require(['select2/compat/matcher'], function (oldMatcher) {
        var defaults = {
            language: 'zh-CN',
            width: '100%',
            matcher: oldMatcher(matchPinyinOrChineseCharacters)
        };
        if (placeholder) {
            defaults.placeholder = placeholder;
        }
        var settings = $.extend(true, {}, defaults, options);
        var select2Ele = $(selector).select2(settings);
        if (typeof defaultValue != 'undefined') {
            select2Ele.val(defaultValue).trigger("change");
        }
    });
}

function matchPinyinOrChineseCharacters(term, text, data) {
    if(term && text) {
        if (text.toUpperCase().indexOf(term.toUpperCase()) > -1) {
            return true;
        }

        var pinyin = chineseCharactersToPinyinAndFirstCharsWithCache(text);
        if (pinyin.toUpperCase().indexOf(term.toUpperCase()) > -1) {
            return true;
        }
    }

    return false;
}

