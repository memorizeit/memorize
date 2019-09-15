function init() {
    initCreateMemoPage();
}

function initCreateMemoPage() {
	let submitMemo = document.querySelector('#submit-memo');
    if (exists(submitMemo)) {
    	submitMemo.addEventListener('click', recordMemo);
    }

}


function recordMemo() {
    let title = document.querySelector('#bbcode-title').value.trim();
    let content = sceditor.instance(bbcodeArea).val().trim();
    let url = '/memo/new';
    let memoId = document.querySelector('#memo-id');

    if (nonExists(title) || nonExists(content)) {
        alert('Fill the title and content of your Memo!');
        return;
    }

    let data = {
        'title': title,
        'content': content
    }

    if (exists(memoId.value)) {
    	data['id'] = memoId.value;
    }

    lockingSave(true);
    $.ajax({
        type: 'POST',
        url: url,
        data: data,
        success: function(data) {
        	if (nonExists(memoId.value)) {
        		M.toast({html: `Memo '${title}' saved.`});
        		document.querySelector('#memo-id').value = data;
        	} else {
        		M.toast({html: `Memo '${title}' updated.`});
        	}
        	lockingSave(false);
        },
        error: function(err) {
            console.log(err);
            M.toast({html: `Memo '${title}' not saved. An error occurred.`});
        	lockingSave(false);
        }
      });

    function lockingSave(lock) {
    	let saveButton = document.querySelector('#submit-memo');

    	if (lock) {
    		saveButton.innerText = "Saving...";
    		saveButton.disabled = true;
    	} else {
    		saveButton.innerText = "Save";
    		saveButton.disabled = false;
    	}
    }
}

function loadMemo() {
	let paths = location.pathname.split('/');
	let memoId = paths[paths.length - 1];
	let url = `/memo/${memoId}`;

	fetch(url)
		.then(response => response.json())
		.then(memo => {
			sceditor.instance(bbcodeArea).val(memo.content);
			document.querySelector('#bbcode-title').value = memo.title;
			console.log(memo);
		})
		.catch(error => {
			console.error(error);
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