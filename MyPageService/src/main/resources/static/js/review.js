// 삭제 기능
const deleteButton = document.getElementById('delete-btn');

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let reviewId = document.getElementById('reviewId').value;
        fetch(`/api/myPage/myReviews/${reviewId}`, {
            method: 'DELETE'
        })
            .then(() => {
                alert('삭제가 완료되었습니다.');
                location.replace('/myPage/myReviews');
            });
    });
}

// 수정 기능
const modifyButton = document.getElementById('modify-btn');

if (modifyButton) {
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let reviewId = params.get('reviewId');

        fetch(`/api/myPage/myReviews/${reviewId}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
				hospitalName: document.getElementById('hospitalName').value,
				visitDate: document.getElementById('visitDate').value,
                text: document.getElementById('text').value,
                rating: document.getElementById('rating').value
            })
        })
            .then(() => {
                alert('수정이 완료되었습니다.');
                location.replace(`/myPage/myReviews/${reviewId}`);
            });
    });
}

// 생성 기능
const createButton = document.getElementById('create-btn');

if (createButton) {
    createButton.addEventListener('click', event => {
        fetch('/api/myPage/myReviews', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
				hospitalName: document.getElementById('hospitalName').value,
				visitDate: document.getElementById('visitDate').value,
				text: document.getElementById('text').value,
				rating: document.getElementById('rating').value
            })
        })
            .then(() => {
                alert('등록 완료되었습니다.');
                location.replace('/myPage/myReviews');
            });
    });
}