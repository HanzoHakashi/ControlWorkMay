function displayPagination(page) {
  const pagination = document.getElementById("pagination");
  pagination.innerHTML = "";

  const pageNumbers = [];
  const totalPages = page.totalPages;
  const currentPage = page.number + 1;
  if (totalPages < 2) {
    return;
  }

  let startPage = 1;
  let endPage = totalPages;

  const maxPages = 5;

  if (totalPages > maxPages) {
    const middle = Math.floor(maxPages / 2);
    if (currentPage <= middle) {
      endPage = maxPages;
    } else if (currentPage + middle >= totalPages) {
      startPage = totalPages - maxPages + 1;
    } else {
      startPage = currentPage - middle;
      endPage = currentPage + middle;
    }
  }

  if (startPage > 1) {
    const li = document.createElement("li");
    const link = document.createElement("a");
    link.href = "#";
    link.innerHTML = "1";
    li.appendChild(link);
    pagination.appendChild(li);
    pagination.appendChild(document.createTextNode("..."));
  }

  for (let i = startPage; i <= endPage; i++) {
    const li = document.createElement("li");
    const link = document.createElement("a");
    link.href = "#";
    link.innerHTML = i;
    if (i === currentPage) {
      li.classList.add("active");
    }
    li.appendChild(link);
    pagination.appendChild(li);
  }

  if (endPage < totalPages) {
    pagination.appendChild(document.createTextNode("..."));
    const li = document.createElement("li");
    const link = document.createElement("a");
    link.href = "#";
    link.innerHTML = totalPages;
    li.appendChild(link);
    pagination.appendChild(li);
  }

  const links = pagination.getElementsByTagName("a");
  for (let i = 0; i < links.length; i++) {
    const link = links[i];
    link.addEventListener("click", async (e) => {
      e.preventDefault();
      const pageNumber = parseInt(link.innerHTML) - 1;
      const response = await fetch(`/?page=${pageNumber}&size=10`);
      const tasks = await response.json();
      displayTasks(tasks.content);
      displayPagination(tasks);
    });
  }
}
