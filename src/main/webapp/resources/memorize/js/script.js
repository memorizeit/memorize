function init() {
    initCreateMemoPage();
}

function initCreateMemoPage() {
    document.querySelector('#submit-memo').addEventListener('click', recordMemo);
}


function recordMemo() {
    let title = document.querySelector('#bbcode-title').value.trim();
    let content = sceditor.instance(bbcodeArea).val().trim();
    let url = '/memo/new';

    if (nonExists(title) || nonExists(content)) {
        alert('Fill the title and content of your Memo!');
        return;
    }

    let data = {
        'title': title,
        'content': content
    }

    $.ajax({
        type: 'POST',
        url: url,
        data: data,
        success: function(data) {
            M.toast({html: `Memo '${title}' saved.`})
        },
        error: function(err) {
            console.log(err);
        }
      });
}

function exists(element) {
    if (element == null || element == undefined || element == 0 || element == [] || element == '') {
        return false;
    } else {
        return true;
    }
}

function nonExists(element) {
    return !exists(element);
}

init();